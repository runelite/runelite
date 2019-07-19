import java.io.DataInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("ez")
@Implements("UrlRequester")
public class UrlRequester implements Runnable {
	@ObfuscatedName("q")
	@Export("thread")
	final Thread thread;
	@ObfuscatedName("w")
	@Export("isClosed")
	volatile boolean isClosed;
	@ObfuscatedName("e")
	@Export("requests")
	Queue requests;

	public UrlRequester() {
		this.requests = new LinkedList();
		this.thread = new Thread(this);
		this.thread.setPriority(1);
		this.thread.start();
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(Ljava/net/URL;B)Lex;",
		garbageValue = "78"
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

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "78"
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
				HitSplatDefinition.sendStackTrace((String)null, var17);
			}
		}

	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(I)Ljava/lang/String;",
		garbageValue = "1670821408"
	)
	@Export("getChatMessagesAsString")
	static String getChatMessagesAsString() {
		String var0 = "";

		Message var2;
		for (Iterator var1 = Messages.Messages_hashTable.iterator(); var1.hasNext(); var0 = var0 + var2.sender + ':' + var2.text + '\n') {
			var2 = (Message)var1.next();
		}

		return var0;
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(ILcx;ZI)I",
		garbageValue = "337474973"
	)
	static int method3306(int var0, Script var1, boolean var2) {
		Widget var3;
		if (var0 == ScriptOpcodes.IF_GETINVOBJECT) {
			var3 = class80.getWidget(Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize]);
			Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = var3.itemId;
			return 1;
		} else if (var0 == ScriptOpcodes.IF_GETINVCOUNT) {
			var3 = class80.getWidget(Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize]);
			if (var3.itemId != -1) {
				Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = var3.itemQuantity;
			} else {
				Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = 0;
			}

			return 1;
		} else if (var0 == ScriptOpcodes.IF_HASSUB) {
			int var5 = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize];
			InterfaceParent var4 = (InterfaceParent)Client.interfaceParents.get((long)var5);
			if (var4 != null) {
				Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = 1;
			} else {
				Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = 0;
			}

			return 1;
		} else if (var0 == ScriptOpcodes.IF_GETTOP) {
			Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = Client.rootInterface;
			return 1;
		} else {
			return 2;
		}
	}
}
