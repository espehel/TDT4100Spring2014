package encapsulation;

public class MobileUsage {
	private int callCount;
	private int callSeconds;
	private int messageCount;
	private int bytesReceived;
	private int bytesSent;
	
	public MobileUsage() {
		this.callCount = 0;
		this.callSeconds = 0;
		this.messageCount = 0;
		this.bytesReceived = 0;
		this.bytesSent = 0;
	}
	public int getCallCount() {
		return callCount;
	}
	public int getCallSeconds() {
		return callSeconds;
	}
	public int getMessageCount() {
		return messageCount;
	}
	public int getBytesReceived() {
		return bytesReceived;
	}
	public int getBytesSent() {
		return bytesSent;
	}
	public void registerCall(int seconds){
		if(seconds >= 0){
			callCount ++;
			callSeconds += seconds;
		}
		else{
			throw new IllegalArgumentException("negative seconds");
		}
	}
	public void registerMessage(){
		messageCount++;
	}
	public void registerBytes(int sent, int received){
		if(sent >= 0 && received >= 0){
			bytesReceived += received;
			bytesSent += sent;
		}
	}
	
}
