import java.io.DataInputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("ff")
@Implements("TaskHandler")
public class TaskHandler implements Runnable {
	@ObfuscatedName("a")
	@Export("javaVendor")
	public static String javaVendor;
	@ObfuscatedName("t")
	@Export("javaVersion")
	public static String javaVersion;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Lfw;"
	)
	@Export("current")
	Task current;
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Lfw;"
	)
	@Export("task")
	Task task;
	@ObfuscatedName("v")
	@Export("thread")
	Thread thread;
	@ObfuscatedName("l")
	@Export("isClosed")
	boolean isClosed;

	public TaskHandler() {
		this.current = null;
		this.task = null;
		this.isClosed = false;
		javaVendor = "Unknown";
		javaVersion = "1.6";

		try {
			javaVendor = System.getProperty("java.vendor");
			javaVersion = System.getProperty("java.version");
		} catch (Exception var2) {
		}

		this.isClosed = false;
		this.thread = new Thread(this);
		this.thread.setPriority(10);
		this.thread.setDaemon(true);
		this.thread.start();
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "6934376"
	)
	@Export("close")
	public final void close() {
		synchronized(this) {
			this.isClosed = true;
			this.notifyAll();
		}

		try {
			this.thread.join();
		} catch (InterruptedException var3) {
		}

	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(IIILjava/lang/Object;I)Lfw;",
		garbageValue = "635480058"
	)
	@Export("newTask")
	final Task newTask(int var1, int var2, int var3, Object var4) {
		Task var5 = new Task();
		var5.type = var1;
		var5.intArgument = var2;
		var5.objectArgument = var4;
		synchronized(this) {
			if (this.task != null) {
				this.task.next = var5;
				this.task = var5;
			} else {
				this.task = this.current = var5;
			}

			this.notify();
			return var5;
		}
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;II)Lfw;",
		garbageValue = "540532004"
	)
	@Export("newSocketTask")
	public final Task newSocketTask(String var1, int var2) {
		return this.newTask(1, var2, 0, var1);
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/Runnable;II)Lfw;",
		garbageValue = "129890916"
	)
	@Export("newThreadTask")
	public final Task newThreadTask(Runnable var1, int var2) {
		return this.newTask(2, var2, 0, var1);
	}

	public final void run() {
		while (true) {
			Task var1;
			synchronized(this) {
				while (true) {
					if (this.isClosed) {
						return;
					}

					if (this.current != null) {
						var1 = this.current;
						this.current = this.current.next;
						if (this.current == null) {
							this.task = null;
						}
						break;
					}

					try {
						this.wait();
					} catch (InterruptedException var8) {
					}
				}
			}

			try {
				int var5 = var1.type;
				if (var5 == 1) {
					var1.result = new Socket(InetAddress.getByName((String)var1.objectArgument), var1.intArgument);
				} else if (var5 == 2) {
					Thread var3 = new Thread((Runnable)var1.objectArgument);
					var3.setDaemon(true);
					var3.start();
					var3.setPriority(var1.intArgument);
					var1.result = var3;
				} else if (var5 == 4) {
					var1.result = new DataInputStream(((URL)var1.objectArgument).openStream());
				}

				var1.status = 1;
			} catch (ThreadDeath var6) {
				throw var6;
			} catch (Throwable var7) {
				var1.status = 2;
			}
		}
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(Lhq;Lhq;Lhq;B)V",
		garbageValue = "48"
	)
	public static void method3622(AbstractArchive var0, AbstractArchive var1, AbstractArchive var2) {
		HitSplatDefinition.HitSplatDefinition_archive = var0;
		HitSplatDefinition.field3316 = var1;
		class2.HitSplatDefinition_fontsArchive = var2;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(ILcj;ZI)I",
		garbageValue = "-1691185784"
	)
	static int method3605(int var0, Script var1, boolean var2) {
		Widget var3;
		if (var0 >= 2000) {
			var0 -= 1000;
			var3 = PacketBufferNode.getWidget(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
		} else {
			var3 = var2 ? class96.field1301 : ReflectionCheck.field1310;
		}

		GrandExchangeOfferAgeComparator.invalidateWidget(var3);
		if (var0 != ScriptOpcodes.CC_SETOBJECT && var0 != ScriptOpcodes.CC_SETOBJECT_NONUM && var0 != ScriptOpcodes.CC_SETOBJECT_ALWAYS_NUM) {
			if (var0 == ScriptOpcodes.CC_SETNPCHEAD) {
				var3.modelType = 2;
				var3.modelId = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
				return 1;
			} else if (var0 == ScriptOpcodes.CC_SETPLAYERHEAD_SELF) {
				var3.modelType = 3;
				var3.modelId = class215.localPlayer.appearance.getChatHeadId();
				return 1;
			} else {
				return 2;
			}
		} else {
			Interpreter.Interpreter_intStackSize -= 2;
			int var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
			int var5 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
			var3.itemId = var4;
			var3.itemQuantity = var5;
			ItemDefinition var6 = class222.ItemDefinition_get(var4);
			var3.modelAngleX = var6.xan2d;
			var3.modelAngleY = var6.yan2d;
			var3.modelAngleZ = var6.zan2d;
			var3.modelOffsetX = var6.offsetX2d;
			var3.modelOffsetY = var6.offsetY2d;
			var3.modelZoom = var6.zoom2d;
			if (var0 == ScriptOpcodes.CC_SETOBJECT_NONUM) {
				var3.itemQuantityMode = 0;
			} else if (var0 == ScriptOpcodes.CC_SETOBJECT_ALWAYS_NUM | var6.isStackable == 1) {
				var3.itemQuantityMode = 1;
			} else {
				var3.itemQuantityMode = 2;
			}

			if (var3.field2577 > 0) {
				var3.modelZoom = var3.modelZoom * 32 / var3.field2577;
			} else if (var3.rawWidth > 0) {
				var3.modelZoom = var3.modelZoom * 32 / var3.rawWidth;
			}

			return 1;
		}
	}

	@ObfuscatedName("iv")
	@ObfuscatedSignature(
		signature = "(Lit;IIII)V",
		garbageValue = "890434158"
	)
	@Export("addNpcToMenu")
	static final void addNpcToMenu(NPCDefinition var0, int var1, int var2, int var3) {
		if (Client.menuOptionsCount < 400) {
			if (var0.transforms != null) {
				var0 = var0.transform();
			}

			if (var0 != null) {
				if (var0.isInteractable) {
					if (!var0.isFollower || Client.followerIndex == var1) {
						String var4 = var0.name;
						if (var0.combatLevel != 0) {
							var4 = var4 + GrandExchangeOffer.method159(var0.combatLevel, class215.localPlayer.combatLevel) + " " + " (" + "level-" + var0.combatLevel + ")";
						}

						if (var0.isFollower && Client.followerOpsLowPriority) {
							GameObject.insertMenuItemNoShift("Examine", AbstractArchive.colorStartTag(16776960) + var4, 1003, var1, var2, var3);
						}

						if (Client.isItemSelected == 1) {
							GameObject.insertMenuItemNoShift("Use", Client.selectedItemName + " " + "->" + " " + AbstractArchive.colorStartTag(16776960) + var4, 7, var1, var2, var3);
						} else if (Client.isSpellSelected) {
							if ((class81.selectedSpellFlags & 2) == 2) {
								GameObject.insertMenuItemNoShift(Client.selectedSpellActionName, Client.selectedSpellName + " " + "->" + " " + AbstractArchive.colorStartTag(16776960) + var4, 8, var1, var2, var3);
							}
						} else {
							int var5 = var0.isFollower && Client.followerOpsLowPriority ? 2000 : 0;
							String[] var6 = var0.actions;
							int var7;
							int var8;
							if (var6 != null) {
								for (var7 = 4; var7 >= 0; --var7) {
									if (var6[var7] != null && !var6[var7].equalsIgnoreCase("Attack")) {
										var8 = 0;
										if (var7 == 0) {
											var8 = var5 + 9;
										}

										if (var7 == 1) {
											var8 = var5 + 10;
										}

										if (var7 == 2) {
											var8 = var5 + 11;
										}

										if (var7 == 3) {
											var8 = var5 + 12;
										}

										if (var7 == 4) {
											var8 = var5 + 13;
										}

										GameObject.insertMenuItemNoShift(var6[var7], AbstractArchive.colorStartTag(16776960) + var4, var8, var1, var2, var3);
									}
								}
							}

							if (var6 != null) {
								for (var7 = 4; var7 >= 0; --var7) {
									if (var6[var7] != null && var6[var7].equalsIgnoreCase("Attack")) {
										short var9 = 0;
										if (AttackOption.AttackOption_hidden != Client.npcAttackOption) {
											if (AttackOption.AttackOption_alwaysRightClick == Client.npcAttackOption || Client.npcAttackOption == AttackOption.AttackOption_dependsOnCombatLevels && var0.combatLevel > class215.localPlayer.combatLevel) {
												var9 = 2000;
											}

											var8 = 0;
											if (var7 == 0) {
												var8 = var9 + 9;
											}

											if (var7 == 1) {
												var8 = var9 + 10;
											}

											if (var7 == 2) {
												var8 = var9 + 11;
											}

											if (var7 == 3) {
												var8 = var9 + 12;
											}

											if (var7 == 4) {
												var8 = var9 + 13;
											}

											GameObject.insertMenuItemNoShift(var6[var7], AbstractArchive.colorStartTag(16776960) + var4, var8, var1, var2, var3);
										}
									}
								}
							}

							if (!var0.isFollower || !Client.followerOpsLowPriority) {
								GameObject.insertMenuItemNoShift("Examine", AbstractArchive.colorStartTag(16776960) + var4, 1003, var1, var2, var3);
							}
						}

					}
				}
			}
		}
	}
}
