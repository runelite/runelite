import java.io.DataInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.LinkedList;
import java.util.Queue;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eg")
@Implements("UrlRequester")
public class UrlRequester implements Runnable {
	@ObfuscatedName("q")
	@Export("ItemDefinition_inMembersWorld")
	public static boolean ItemDefinition_inMembersWorld;
	@ObfuscatedName("s")
	@Export("thread")
	final Thread thread;
	@ObfuscatedName("j")
	@Export("isClosed")
	volatile boolean isClosed;
	@ObfuscatedName("i")
	@Export("requests")
	Queue requests;

	public UrlRequester() {
		this.requests = new LinkedList();
		this.thread = new Thread(this);
		this.thread.setPriority(1);
		this.thread.start();
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(Ljava/net/URL;I)Ler;",
		garbageValue = "-2144304938"
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

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1101438490"
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
				class3.RunException_sendStackTrace((String)null, var17);
			}
		}

	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(IB)V",
		garbageValue = "-75"
	)
	public static void method3250(int var0) {
		if (var0 != -1) {
			if (WorldMapDecoration.Widget_loadedInterfaces[var0]) {
				Widget.Widget_archive.clearFilesGroup(var0);
				if (Widget.Widget_interfaceComponents[var0] != null) {
					boolean var1 = true;

					for (int var2 = 0; var2 < Widget.Widget_interfaceComponents[var0].length; ++var2) {
						if (Widget.Widget_interfaceComponents[var0][var2] != null) {
							if (Widget.Widget_interfaceComponents[var0][var2].type != 2) {
								Widget.Widget_interfaceComponents[var0][var2] = null;
							} else {
								var1 = false;
							}
						}
					}

					if (var1) {
						Widget.Widget_interfaceComponents[var0] = null;
					}

					WorldMapDecoration.Widget_loadedInterfaces[var0] = false;
				}
			}
		}
	}
}
