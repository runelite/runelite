import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("m")
@Implements("GrandExchangeOfferUnitPriceComparator")
final class GrandExchangeOfferUnitPriceComparator implements Comparator {
	@ObfuscatedName("w")
	@Export("localPlayerName")
	public static String localPlayerName;

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(Li;Li;B)I",
		garbageValue = "-46"
	)
	@Export("compare_bridged")
	int compare_bridged(GrandExchangeEvent var1, GrandExchangeEvent var2) {
		return var1.grandExchangeOffer.unitPrice < var2.grandExchangeOffer.unitPrice ? -1 : (var2.grandExchangeOffer.unitPrice == var1.grandExchangeOffer.unitPrice ? 0 : 1);
	}

	public int compare(Object var1, Object var2) {
		return this.compare_bridged((GrandExchangeEvent)var1, (GrandExchangeEvent)var2);
	}

	public boolean equals(Object var1) {
		return super.equals(var1);
	}

	@ObfuscatedName("jp")
	@ObfuscatedSignature(
		signature = "(IB)V",
		garbageValue = "31"
	)
	static final void method124(int var0) {
		class65.method1176();

		for (ObjectSound var1 = (ObjectSound)ObjectSound.objectSounds.last(); var1 != null; var1 = (ObjectSound)ObjectSound.objectSounds.previous()) {
			if (var1.obj != null) {
				var1.set();
			}
		}

		int var4 = GrandExchangeOfferWorldComparator.method61(var0).type;
		if (var4 != 0) {
			int var2 = Varps.Varps_main[var0];
			if (var4 == 1) {
				if (var2 == 1) {
					Rasterizer3D.Rasterizer3D_setBrightness(0.9D);
					((TextureProvider)Rasterizer3D.Rasterizer3D_textureLoader).setBrightness(0.9D);
				}

				if (var2 == 2) {
					Rasterizer3D.Rasterizer3D_setBrightness(0.8D);
					((TextureProvider)Rasterizer3D.Rasterizer3D_textureLoader).setBrightness(0.8D);
				}

				if (var2 == 3) {
					Rasterizer3D.Rasterizer3D_setBrightness(0.7D);
					((TextureProvider)Rasterizer3D.Rasterizer3D_textureLoader).setBrightness(0.7D);
				}

				if (var2 == 4) {
					Rasterizer3D.Rasterizer3D_setBrightness(0.6D);
					((TextureProvider)Rasterizer3D.Rasterizer3D_textureLoader).setBrightness(0.6D);
				}

				FontName.method5317();
			}

			if (var4 == 3) {
				short var3 = 0;
				if (var2 == 0) {
					var3 = 255;
				}

				if (var2 == 1) {
					var3 = 192;
				}

				if (var2 == 2) {
					var3 = 128;
				}

				if (var2 == 3) {
					var3 = 64;
				}

				if (var2 == 4) {
					var3 = 0;
				}

				if (var3 != Client.field911) {
					if (Client.field911 == 0 && Client.field889 != -1) {
						class169.method3503(WorldMapRegion.archive6, Client.field889, 0, var3, false);
						Client.field699 = false;
					} else if (var3 == 0) {
						NetSocket.method3553();
						Client.field699 = false;
					} else if (class197.field2402 != 0) {
						ScriptFrame.field529 = var3;
					} else {
						Interpreter.midiPcmStream.method3706(var3);
					}

					Client.field911 = var3;
				}
			}

			if (var4 == 4) {
				if (var2 == 0) {
					Client.soundEffectVolume = 127;
				}

				if (var2 == 1) {
					Client.soundEffectVolume = 96;
				}

				if (var2 == 2) {
					Client.soundEffectVolume = 64;
				}

				if (var2 == 3) {
					Client.soundEffectVolume = 32;
				}

				if (var2 == 4) {
					Client.soundEffectVolume = 0;
				}
			}

			if (var4 == 5) {
				Client.field789 = var2;
			}

			if (var4 == 6) {
				Client.chatEffects = var2;
			}

			if (var4 == 9) {
				Client.field809 = var2;
			}

			if (var4 == 10) {
				if (var2 == 0) {
					Client.field892 = 127;
				}

				if (var2 == 1) {
					Client.field892 = 96;
				}

				if (var2 == 2) {
					Client.field892 = 64;
				}

				if (var2 == 3) {
					Client.field892 = 32;
				}

				if (var2 == 4) {
					Client.field892 = 0;
				}
			}

			if (var4 == 17) {
				Client.followerIndex = var2 & 65535;
			}

			if (var4 == 18) {
				Client.playerAttackOption = (AttackOption)SoundSystem.findEnumerated(AbstractArchive.method4141(), var2);
				if (Client.playerAttackOption == null) {
					Client.playerAttackOption = AttackOption.AttackOption_dependsOnCombatLevels;
				}
			}

			if (var4 == 19) {
				if (var2 == -1) {
					Client.combatTargetPlayerIndex = -1;
				} else {
					Client.combatTargetPlayerIndex = var2 & 2047;
				}
			}

			if (var4 == 22) {
				Client.npcAttackOption = (AttackOption)SoundSystem.findEnumerated(AbstractArchive.method4141(), var2);
				if (Client.npcAttackOption == null) {
					Client.npcAttackOption = AttackOption.AttackOption_dependsOnCombatLevels;
				}
			}

		}
	}
}
