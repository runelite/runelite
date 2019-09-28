import java.io.DataInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.LinkedList;
import java.util.Queue;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("en")
@Implements("UrlRequester")
public class UrlRequester implements Runnable {
	@ObfuscatedName("u")
	@Export("Interpreter_stringLocals")
	static String[] Interpreter_stringLocals;
	@ObfuscatedName("kx")
	@ObfuscatedGetter(
		intValue = 1912035221
	)
	@Export("menuX")
	static int menuX;
	@ObfuscatedName("z")
	@Export("thread")
	final Thread thread;
	@ObfuscatedName("n")
	@Export("isClosed")
	volatile boolean isClosed;
	@ObfuscatedName("v")
	@Export("requests")
	Queue requests;

	public UrlRequester() {
		this.requests = new LinkedList();
		this.thread = new Thread(this);
		this.thread.setPriority(1);
		this.thread.start();
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(Ljava/net/URL;I)Leh;",
		garbageValue = "1658949504"
	)
	@Export("request")
	public UrlRequest request(URL var1) {
		UrlRequest var2 = new UrlRequest(var1);
		synchronized(this) {
			this.requests.add(var2);
			this.notify();
			return var2;
		}
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1861698120"
	)
	@Export("close")
	public void close() {
		this.isClosed = true;

		try {
			synchronized(this) {
				this.notify();
			}

			this.thread.join();
		} catch (InterruptedException var4) {
		}

	}

	public void run() {
		while (!this.isClosed) {
			try {
				UrlRequest var1;
				synchronized(this) {
					var1 = (UrlRequest)this.requests.poll();
					if (var1 == null) {
						try {
							this.wait();
						} catch (InterruptedException var13) {
						}
						continue;
					}
				}

				DataInputStream var2 = null;
				URLConnection var3 = null;

				try {
					var3 = var1.url.openConnection();
					var3.setConnectTimeout(5000);
					var3.setReadTimeout(5000);
					var3.setUseCaches(false);
					var3.setRequestProperty("Connection", "close");
					int var7 = var3.getContentLength();
					if (var7 >= 0) {
						byte[] var5 = new byte[var7];
						var2 = new DataInputStream(var3.getInputStream());
						var2.readFully(var5);
						var1.response0 = var5;
					}

					var1.isDone0 = true;
				} catch (IOException var14) {
					var1.isDone0 = true;
				} finally {
					if (var2 != null) {
						var2.close();
					}

					if (var3 != null && var3 instanceof HttpURLConnection) {
						((HttpURLConnection)var3).disconnect();
					}

				}
			} catch (Exception var17) {
				class32.RunException_sendStackTrace((String)null, var17);
			}
		}

	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(CI)C",
		garbageValue = "1748894504"
	)
	static char method3260(char var0) {
		return var0 != 181 && var0 != 402 ? Character.toTitleCase(var0) : var0;
	}
}
