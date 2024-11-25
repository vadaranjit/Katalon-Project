package customKeywords

import javax.mail.*
import javax.mail.internet.*
import javax.mail.search.*
import java.util.Properties

import com.kms.katalon.core.annotation.Keyword

class OutlookEmailReader {

	@Keyword
	def connectToOutlook(String username, String password) {
		Properties props = new Properties()
		props.put("mail.store.protocol", "imaps")
		props.put("mail.imap.host", "outlook.office365.com")
		props.put("mail.imap.port", "993")
		props.put("mail.imap.starttls.enable", "true")

		Session session = Session.getDefaultInstance(props, null)
		Store store = session.getStore("imaps")
		store.connect("outlook.office365.com", username, password)

		return store
	}

	@Keyword
	def getEmails(String username, String password, String folderName = "INBOX") {
		Store store = connectToOutlook(username, password)
		Folder emailFolder = store.getFolder(folderName)
		emailFolder.open(Folder.READ_ONLY)

		Message[] messages = emailFolder.getMessages()

		for (Message message : messages) {
			println("Email Subject: " + message.getSubject())
			println("Email From: " + message.getFrom()[0])
			println("Email Body: " + getTextFromMessage(message))
		}

		emailFolder.close(false)
		store.close()
	}

	@Keyword
	def getTextFromMessage(Message message) {
		String result = ""
		if (message.isMimeType("text/plain")) {
			result = message.getContent().toString()
		} else if (message.isMimeType("multipart/*")) {
			MimeMultipart mimeMultipart = (MimeMultipart) message.getContent()
			result = getTextFromMimeMultipart(mimeMultipart)
		}
		return result
	}

	private String getTextFromMimeMultipart(MimeMultipart mimeMultipart) throws Exception {
		StringBuilder result = new StringBuilder()
		int count = mimeMultipart.getCount()
		for (int i = 0; i < count; i++) {
			BodyPart bodyPart = mimeMultipart.getBodyPart(i)
			if (bodyPart.isMimeType("text/plain")) {
				result.append(bodyPart.getContent())
			} else if (bodyPart.isMimeType("text/html")) {
				result.append(org.jsoup.Jsoup.parse(bodyPart.getContent().toString()).text())
			} else if (bodyPart.getContent() instanceof MimeMultipart) {
				result.append(getTextFromMimeMultipart((MimeMultipart) bodyPart.getContent()))
			}
		}
		return result.toString()
	}
}
