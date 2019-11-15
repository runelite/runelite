import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("y")
@Implements("WorldMapDecoration")
public class WorldMapDecoration {
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = 1903758255
	)
	@Export("Interpreter_stringStackSize")
	static int Interpreter_stringStackSize;
	@ObfuscatedName("de")
	@ObfuscatedSignature(
		signature = "Lij;"
	)
	@Export("archive18")
	static Archive archive18;
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = -1209347133
	)
	@Export("objectDefinitionId")
	final int objectDefinitionId;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = 255177035
	)
	@Export("decoration")
	final int decoration;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = 1587770673
	)
	@Export("rotation")
	final int rotation;

	WorldMapDecoration(int var1, int var2, int var3) {
		this.objectDefinitionId = var1;
		this.decoration = var2;
		this.rotation = var3;
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(Lln;I)I",
		garbageValue = "793189835"
	)
	public static final int method388(LoginType var0) {
		if (var0 == null) {
			return 12;
		} else {
			switch(var0.field4033) {
			case 8:
				return 20;
			default:
				return 12;
			}
		}
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(II)Lis;",
		garbageValue = "-1932549468"
	)
	@Export("FloorUnderlayDefinition_get")
	public static FloorOverlayDefinition FloorUnderlayDefinition_get(int var0) {
		FloorOverlayDefinition var1 = (FloorOverlayDefinition)FloorOverlayDefinition.FloorOverlayDefinition_cached.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = FloorOverlayDefinition.FloorOverlayDefinition_archive.takeFile(4, var0);
			var1 = new FloorOverlayDefinition();
			if (var2 != null) {
				var1.decode(new Buffer(var2), var0);
			}

			var1.postDecode();
			FloorOverlayDefinition.FloorOverlayDefinition_cached.put(var1, (long)var0);
			return var1;
		}
	}

	@ObfuscatedName("t")
	@Export("base37DecodeLong")
	public static String base37DecodeLong(long var0) {
		if (var0 > 0L && var0 < 6582952005840035281L) {
			if (var0 % 37L == 0L) {
				return null;
			} else {
				int var2 = 0;

				for (long var3 = var0; var3 != 0L; var3 /= 37L) {
					++var2;
				}

				StringBuilder var5;
				char var8;
				for (var5 = new StringBuilder(var2); var0 != 0L; var5.append(var8)) {
					long var6 = var0;
					var0 /= 37L;
					var8 = class288.base37Table[(int)(var6 - var0 * 37L)];
					if (var8 == '_') {
						int var9 = var5.length() - 1;
						var5.setCharAt(var9, Character.toUpperCase(var5.charAt(var9)));
						var8 = 160;
					}
				}

				var5.reverse();
				var5.setCharAt(0, Character.toUpperCase(var5.charAt(0)));
				return var5.toString();
			}
		} else {
			return null;
		}
	}

	@ObfuscatedName("gt")
	@ObfuscatedSignature(
		signature = "(Lbz;I)V",
		garbageValue = "1724378098"
	)
	static final void method386(Actor var0) {
		int var1 = var0.field925 - Client.cycle;
		int var2 = var0.field966 * 128 + var0.field927 * 64;
		int var3 = var0.field979 * 128 + var0.field927 * 64;
		var0.x += (var2 - var0.x) / var1;
		var0.y += (var3 - var0.y) / var1;
		var0.field982 = 0;
		var0.orientation = var0.field972;
	}

	@ObfuscatedName("kj")
	@ObfuscatedSignature(
		signature = "(IB)V",
		garbageValue = "-115"
	)
	@Export("changeGameOptions")
	static final void changeGameOptions(int var0) {
		BoundaryObject.method3393();

		for (ObjectSound var1 = (ObjectSound)ObjectSound.objectSounds.last(); var1 != null; var1 = (ObjectSound)ObjectSound.objectSounds.previous()) {
			if (var1.obj != null) {
				var1.set();
			}
		}

		int var4 = Varcs.VarpDefinition_get(var0).type;
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

				ItemDefinition.ItemDefinition_cachedSprites.clear();
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

				if (var3 != Client.musicVolume) {
					if (Client.musicVolume == 0 && Client.currentTrackGroupId != -1) {
						MusicPatchNode2.playMusicTrack(class216.archive6, Client.currentTrackGroupId, 0, var3, false);
						Client.field855 = false;
					} else if (var3 == 0) {
						ReflectionCheck.method2438();
						Client.field855 = false;
					} else if (class197.field2377 != 0) {
						class197.musicTrackVolume = var3;
					} else {
						class197.midiPcmStream.setPcmStreamVolume(var3);
					}

					Client.musicVolume = var3;
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
				Client.leftClickOpensMenu = var2;
			}

			if (var4 == 6) {
				Client.chatEffects = var2;
			}

			if (var4 == 9) {
				Client.field907 = var2;
			}

			if (var4 == 10) {
				if (var2 == 0) {
					Client.areaSoundEffectVolume = 127;
				}

				if (var2 == 1) {
					Client.areaSoundEffectVolume = 96;
				}

				if (var2 == 2) {
					Client.areaSoundEffectVolume = 64;
				}

				if (var2 == 3) {
					Client.areaSoundEffectVolume = 32;
				}

				if (var2 == 4) {
					Client.areaSoundEffectVolume = 0;
				}
			}

			if (var4 == 17) {
				Client.followerIndex = var2 & 65535;
			}

			AttackOption[] var5;
			if (var4 == 18) {
				var5 = new AttackOption[]{AttackOption.AttackOption_alwaysRightClick, AttackOption.AttackOption_leftClickWhereAvailable, AttackOption.AttackOption_dependsOnCombatLevels, AttackOption.AttackOption_hidden};
				Client.playerAttackOption = (AttackOption)WorldMapIcon_1.findEnumerated(var5, var2);
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
				var5 = new AttackOption[]{AttackOption.AttackOption_alwaysRightClick, AttackOption.AttackOption_leftClickWhereAvailable, AttackOption.AttackOption_dependsOnCombatLevels, AttackOption.AttackOption_hidden};
				Client.npcAttackOption = (AttackOption)WorldMapIcon_1.findEnumerated(var5, var2);
				if (Client.npcAttackOption == null) {
					Client.npcAttackOption = AttackOption.AttackOption_dependsOnCombatLevels;
				}
			}

		}
	}

	@ObfuscatedName("ki")
	@ObfuscatedSignature(
		signature = "(IIII)Lbq;",
		garbageValue = "386978501"
	)
	static final InterfaceParent method385(int var0, int var1, int var2) {
		InterfaceParent var3 = new InterfaceParent();
		var3.group = var1;
		var3.type = var2;
		Client.interfaceParents.put(var3, (long)var0);
		WorldMapLabel.Widget_resetModelFrames(var1);
		Widget var4 = PacketBufferNode.getWidget(var0);
		GrandExchangeOfferAgeComparator.invalidateWidget(var4);
		if (Client.meslayerContinueWidget != null) {
			GrandExchangeOfferAgeComparator.invalidateWidget(Client.meslayerContinueWidget);
			Client.meslayerContinueWidget = null;
		}

		for (int var5 = 0; var5 < Client.menuOptionsCount; ++var5) {
			if (WorldMapIcon_1.method351(Client.menuOpcodes[var5])) {
				if (var5 < Client.menuOptionsCount - 1) {
					for (int var6 = var5; var6 < Client.menuOptionsCount - 1; ++var6) {
						Client.menuActions[var6] = Client.menuActions[var6 + 1];
						Client.menuTargets[var6] = Client.menuTargets[var6 + 1];
						Client.menuOpcodes[var6] = Client.menuOpcodes[var6 + 1];
						Client.menuIdentifiers[var6] = Client.menuIdentifiers[var6 + 1];
						Client.menuArguments1[var6] = Client.menuArguments1[var6 + 1];
						Client.menuArguments2[var6] = Client.menuArguments2[var6 + 1];
						Client.menuShiftClick[var6] = Client.menuShiftClick[var6 + 1];
					}
				}

				--var5;
				--Client.menuOptionsCount;
			}
		}

		class30.method603();
		class43.revalidateWidgetScroll(Widget.Widget_interfaceComponents[var0 >> 16], var4, false);
		FaceNormal.runWidgetOnLoadListener(var1);
		if (Client.rootInterface != -1) {
			AttackOption.runIntfCloseListeners(Client.rootInterface, 1);
		}

		return var3;
	}
}
