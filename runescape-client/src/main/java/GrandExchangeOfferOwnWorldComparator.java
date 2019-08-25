import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("by")
@Implements("GrandExchangeOfferOwnWorldComparator")
public class GrandExchangeOfferOwnWorldComparator implements Comparator {
	@ObfuscatedName("h")
	@Export("operatingSystemLC")
	public static String operatingSystemLC;
	@ObfuscatedName("dm")
	@ObfuscatedSignature(
		signature = "Liu;"
	)
	@Export("archive15")
	static Archive archive15;
	@ObfuscatedName("q")
	@Export("filterWorlds")
	boolean filterWorlds;

	GrandExchangeOfferOwnWorldComparator() {
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(Li;Li;I)I",
		garbageValue = "150441453"
	)
	@Export("compare_bridged")
	int compare_bridged(GrandExchangeEvent var1, GrandExchangeEvent var2) {
		if (var2.world == var1.world) {
			return 0;
		}
		if (this.filterWorlds) {
			if (Client.worldId == var1.world) {
				return -1;
			}

			if (var2.world == Client.worldId) {
				return 1;
			}
		}

		return var1.world < var2.world ? -1 : 1;
	}

	public boolean equals(Object var1) {
		return super.equals(var1);
	}

	public int compare(Object var1, Object var2) {
		return this.compare_bridged((GrandExchangeEvent)var1, (GrandExchangeEvent)var2);
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(II)I",
		garbageValue = "-836499887"
	)
	@Export("getVarbit")
	public static int getVarbit(int var0) {
		VarbitDefinition var2 = (VarbitDefinition)VarbitDefinition.VarbitDefinition_cached.get((long)var0);
		VarbitDefinition var1;
		if (var2 != null) {
			var1 = var2;
		} else {
			byte[] var7 = VarbitDefinition.VarbitDefinition_archive.takeFile(14, var0);
			var2 = new VarbitDefinition();
			if (var7 != null) {
				var2.decode(new Buffer(var7));
			}

			VarbitDefinition.VarbitDefinition_cached.put(var2, (long)var0);
			var1 = var2;
		}

		int var3 = var1.baseVar;
		int var4 = var1.startBit;
		int var5 = var1.endBit;
		int var6 = Varps.Varps_masks[var5 - var4];
		return Varps.Varps_main[var3] >> var4 & var6;
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(IIIIIILer;Lfv;S)V",
		garbageValue = "-19782"
	)
	static final void method1236(int plane, int x, int y, int objectID, int rotation, int objectType, Scene var6, CollisionMap var7) {
		if (Client.isLowDetail && (Tiles.Tiles_renderFlags[0][x][y] & 2) == 0 && (Tiles.Tiles_renderFlags[plane][x][y] & 16) != 0) {
			return;
		}
		if (plane < Tiles.Tiles_minPlane) {
			Tiles.Tiles_minPlane = plane;
		}

		ObjectDefinition var8 = ViewportMouse.getObjectDefinition(objectID);
		int var9;
		int var10;
		if (rotation != 1 && rotation != 3) {
			var9 = var8.sizeX;
			var10 = var8.sizeY;
		} else {
			var9 = var8.sizeY;
			var10 = var8.sizeX;
		}

		int var11;
		int var12;
		if (var9 + x <= 104) {
			var11 = (var9 >> 1) + x;
			var12 = (var9 + 1 >> 1) + x;
		} else {
			var11 = x;
			var12 = x + 1;
		}

		int var13;
		int var14;
		if (var10 + y <= 104) {
			var13 = (var10 >> 1) + y;
			var14 = y + (var10 + 1 >> 1);
		} else {
			var13 = y;
			var14 = y + 1;
		}

		int[][] var15 = Tiles.Tiles_heights[plane];
		int var16 = var15[var11][var14] + var15[var12][var13] + var15[var11][var13] + var15[var12][var14] >> 2;
		int var17 = (x << 7) + (var9 << 6);
		int var18 = (y << 7) + (var10 << 6);
		long var19 = Tile.calculateTag(x, y, 2, var8.int1 == 0, objectID);
		int var21 = objectType + (rotation << 6);
		if (var8.int3 == 1) {
			var21 += 256;
		}

		if (var8.hasSound()) {
			class83.newObjectSound(plane, x, y, var8, rotation);
		}

		Object var22;
		if (objectType == 22) {
			if (Client.isLowDetail && var8.int1 == 0 && var8.interactType != 1 && !var8.boolean2) {
				return;
			}
			if (var8.animationId == -1 && var8.transforms == null) {
				var22 = var8.getEntity(22, rotation, var15, var17, var16, var18);
			} else {
				var22 = new DynamicObject(objectID, 22, rotation, plane, x, y, var8.animationId, true, (Entity)null);
			}

			var6.newFloorDecoration(plane, x, y, var16, (Entity)var22, var19, var21);
			if (var8.interactType == 1 && var7 != null) {
				var7.setBlockedByFloorDec(x, y);
			}

		} else if (objectType == 10 || objectType == 11) {
			if (var8.animationId == -1 && var8.transforms == null) {
				var22 = var8.getEntity(10, rotation, var15, var17, var16, var18);
			} else {
				var22 = new DynamicObject(objectID, 10, rotation, plane, x, y, var8.animationId, true, (Entity) null);
			}

			if (var22 != null && var6.method3076(plane, x, y, var16, var9, var10, (Entity) var22, objectType == 11 ? 256 : 0, var19, var21) && var8.clipped) {
				int var23 = 15;
				if (var22 instanceof Model) {
					var23 = ((Model) var22).method2864() / 4;
					if (var23 > 30) {
						var23 = 30;
					}
				}

				for (int var24 = 0; var24 <= var9; ++var24) {
					for (int var25 = 0; var25 <= var10; ++var25) {
						if (var23 > class32.field282[plane][var24 + x][var25 + y]) {
							class32.field282[plane][var24 + x][var25 + y] = (byte) var23;
						}
					}
				}
			}

			if (var8.interactType != 0 && var7 != null) {
				var7.addGameObject(x, y, var9, var10, var8.boolean1);
			}

		} else if (objectType >= 12) {
			if (var8.animationId == -1 && var8.transforms == null) {
				var22 = var8.getEntity(objectType, rotation, var15, var17, var16, var18);
			} else {
				var22 = new DynamicObject(objectID, objectType, rotation, plane, x, y, var8.animationId, true, (Entity) null);
			}

			var6.method3076(plane, x, y, var16, 1, 1, (Entity) var22, 0, var19, var21);
			if (objectType >= 12 && objectType <= 17 && objectType != 13 && plane > 0) {
				FaceNormal.field1887[plane][x][y] |= 2340;
			}

			if (var8.interactType != 0 && var7 != null) {
				var7.addGameObject(x, y, var9, var10, var8.boolean1);
			}

		} else if (objectType == 0) {
			if (var8.animationId == -1 && var8.transforms == null) {
				var22 = var8.getEntity(0, rotation, var15, var17, var16, var18);
			} else {
				var22 = new DynamicObject(objectID, 0, rotation, plane, x, y, var8.animationId, true, (Entity) null);
			}

			var6.newBoundaryObject(plane, x, y, var16, (Entity) var22, (Entity) null, Tiles.field512[rotation], 0, var19, var21);
			if (rotation == 0) {
				if (var8.clipped) {
					class32.field282[plane][x][y] = 50;
					class32.field282[plane][x][y + 1] = 50;
				}

				if (var8.modelClipped) {
					FaceNormal.field1887[plane][x][y] |= 585;
				}
			} else if (rotation == 1) {
				if (var8.clipped) {
					class32.field282[plane][x][y + 1] = 50;
					class32.field282[plane][x + 1][y + 1] = 50;
				}

				if (var8.modelClipped) {
					FaceNormal.field1887[plane][x][1 + y] |= 1170;
				}
			} else if (rotation == 2) {
				if (var8.clipped) {
					class32.field282[plane][x + 1][y] = 50;
					class32.field282[plane][x + 1][y + 1] = 50;
				}

				if (var8.modelClipped) {
					FaceNormal.field1887[plane][x + 1][y] |= 585;
				}
			} else if (rotation == 3) {
				if (var8.clipped) {
					class32.field282[plane][x][y] = 50;
					class32.field282[plane][x + 1][y] = 50;
				}

				if (var8.modelClipped) {
					FaceNormal.field1887[plane][x][y] |= 1170;
				}
			}

			if (var8.interactType != 0 && var7 != null) {
				var7.method3559(x, y, objectType, rotation, var8.boolean1);
			}

			if (var8.int2 != 16) {
				var6.method3082(plane, x, y, var8.int2);
			}

		} else if (objectType == 1) {
			if (var8.animationId == -1 && var8.transforms == null) {
				var22 = var8.getEntity(1, rotation, var15, var17, var16, var18);
			} else {
				var22 = new DynamicObject(objectID, 1, rotation, plane, x, y, var8.animationId, true, (Entity) null);
			}

			var6.newBoundaryObject(plane, x, y, var16, (Entity) var22, (Entity) null, Tiles.field513[rotation], 0, var19, var21);
			if (var8.clipped) {
				if (rotation == 0) {
					class32.field282[plane][x][y + 1] = 50;
				} else if (rotation == 1) {
					class32.field282[plane][x + 1][y + 1] = 50;
				} else if (rotation == 2) {
					class32.field282[plane][x + 1][y] = 50;
				} else if (rotation == 3) {
					class32.field282[plane][x][y] = 50;
				}
			}

			if (var8.interactType != 0 && var7 != null) {
				var7.method3559(x, y, objectType, rotation, var8.boolean1);
			}

		} else if (objectType == 2) {
			int var28 = rotation + 1 & 3;
			Object var29;
			Object var30;
			if (var8.animationId == -1 && var8.transforms == null) {
				var29 = var8.getEntity(2, rotation + 4, var15, var17, var16, var18);
				var30 = var8.getEntity(2, var28, var15, var17, var16, var18);
			} else {
				var29 = new DynamicObject(objectID, 2, rotation + 4, plane, x, y, var8.animationId, true, (Entity) null);
				var30 = new DynamicObject(objectID, 2, var28, plane, x, y, var8.animationId, true, (Entity) null);
			}

			var6.newBoundaryObject(plane, x, y, var16, (Entity) var29, (Entity) var30, Tiles.field512[rotation], Tiles.field512[var28], var19, var21);
			if (var8.modelClipped) {
				if (rotation == 0) {
					FaceNormal.field1887[plane][x][y] |= 585;
					FaceNormal.field1887[plane][x][y + 1] |= 1170;
				} else if (rotation == 1) {
					FaceNormal.field1887[plane][x][y + 1] |= 1170;
					FaceNormal.field1887[plane][x + 1][y] |= 585;
				} else if (rotation == 2) {
					FaceNormal.field1887[plane][x + 1][y] |= 585;
					FaceNormal.field1887[plane][x][y] |= 1170;
				} else if (rotation == 3) {
					FaceNormal.field1887[plane][x][y] |= 1170;
					FaceNormal.field1887[plane][x][y] |= 585;
				}
			}

			if (var8.interactType != 0 && var7 != null) {
				var7.method3559(x, y, objectType, rotation, var8.boolean1);
			}

			if (var8.int2 != 16) {
				var6.method3082(plane, x, y, var8.int2);
			}

		} else if (objectType == 3) {
			if (var8.animationId == -1 && var8.transforms == null) {
				var22 = var8.getEntity(3, rotation, var15, var17, var16, var18);
			} else {
				var22 = new DynamicObject(objectID, 3, rotation, plane, x, y, var8.animationId, true, (Entity) null);
			}

			var6.newBoundaryObject(plane, x, y, var16, (Entity) var22, (Entity) null, Tiles.field513[rotation], 0, var19, var21);
			if (var8.clipped) {
				if (rotation == 0) {
					class32.field282[plane][x][y + 1] = 50;
				} else if (rotation == 1) {
					class32.field282[plane][x + 1][y + 1] = 50;
				} else if (rotation == 2) {
					class32.field282[plane][x + 1][y] = 50;
				} else if (rotation == 3) {
					class32.field282[plane][x][y] = 50;
				}
			}

			if (var8.interactType != 0 && var7 != null) {
				var7.method3559(x, y, objectType, rotation, var8.boolean1);
			}

		} else if (objectType == 9) {
			if (var8.animationId == -1 && var8.transforms == null) {
				var22 = var8.getEntity(objectType, rotation, var15, var17, var16, var18);
			} else {
				var22 = new DynamicObject(objectID, objectType, rotation, plane, x, y, var8.animationId, true, (Entity) null);
			}

			var6.method3076(plane, x, y, var16, 1, 1, (Entity) var22, 0, var19, var21);
			if (var8.interactType != 0 && var7 != null) {
				var7.addGameObject(x, y, var9, var10, var8.boolean1);
			}

			if (var8.int2 != 16) {
				var6.method3082(plane, x, y, var8.int2);
			}

		} else if (objectType == 4) {
			if (var8.animationId == -1 && var8.transforms == null) {
				var22 = var8.getEntity(4, rotation, var15, var17, var16, var18);
			} else {
				var22 = new DynamicObject(objectID, 4, rotation, plane, x, y, var8.animationId, true, (Entity) null);
			}

			var6.newWallDecoration(plane, x, y, var16, (Entity) var22, (Entity) null, Tiles.field512[rotation], 0, 0, 0, var19, var21);
		} else if (objectType == 5) {
			int var28 = 16;
			long var31 = var6.getBoundaryObjectTag(plane, x, y);
			Object var33;
			if (var31 != 0L) {
				var28 = ViewportMouse.getObjectDefinition(class43.Entity_unpackID(var31)).int2;
			}

			if (var8.animationId == -1 && var8.transforms == null) {
				var33 = var8.getEntity(4, rotation, var15, var17, var16, var18);
			} else {
				var33 = new DynamicObject(objectID, 4, rotation, plane, x, y, var8.animationId, true, (Entity) null);
			}

			var6.newWallDecoration(plane, x, y, var16, (Entity) var33, (Entity) null, Tiles.field512[rotation], 0, var28 * Tiles.field514[rotation], var28 * Tiles.field520[rotation], var19, var21);
		} else if (objectType == 6) {
			int var28 = 8;
			long var31 = var6.getBoundaryObjectTag(plane, x, y);
			Object var33;
			if (0L != var31) {
				var28 = ViewportMouse.getObjectDefinition(class43.Entity_unpackID(var31)).int2 / 2;
			}

			if (var8.animationId == -1 && var8.transforms == null) {
				var33 = var8.getEntity(4, rotation + 4, var15, var17, var16, var18);
			} else {
				var33 = new DynamicObject(objectID, 4, rotation + 4, plane, x, y, var8.animationId, true, (Entity) null);
			}

			var6.newWallDecoration(plane, x, y, var16, (Entity) var33, (Entity) null, 256, rotation, var28 * Tiles.field509[rotation], var28 * Tiles.field517[rotation], var19, var21);
		} else if (objectType == 7) {
			int var23 = rotation + 2 & 3;
			if (var8.animationId == -1 && var8.transforms == null) {
				var22 = var8.getEntity(4, var23 + 4, var15, var17, var16, var18);
			} else {
				var22 = new DynamicObject(objectID, 4, var23 + 4, plane, x, y, var8.animationId, true, (Entity) null);
			}

			var6.newWallDecoration(plane, x, y, var16, (Entity) var22, (Entity) null, 256, var23, 0, 0, var19, var21);
		} else if (objectType == 8) {
			int var28 = 8;
			long var31 = var6.getBoundaryObjectTag(plane, x, y);
			if (var31 != 0L) {
				var28 = ViewportMouse.getObjectDefinition(class43.Entity_unpackID(var31)).int2 / 2;
			}

			int var27 = rotation + 2 & 3;
			Object var26;
			Object var33;
			if (var8.animationId == -1 && var8.transforms == null) {
				var33 = var8.getEntity(4, rotation + 4, var15, var17, var16, var18);
				var26 = var8.getEntity(4, var27 + 4, var15, var17, var16, var18);
			} else {
				var33 = new DynamicObject(objectID, 4, rotation + 4, plane, x, y, var8.animationId, true, (Entity) null);
				var26 = new DynamicObject(objectID, 4, var27 + 4, plane, x, y, var8.animationId, true, (Entity) null);
			}

			var6.newWallDecoration(plane, x, y, var16, (Entity) var33, (Entity) var26, 256, rotation, var28 * Tiles.field509[rotation], var28 * Tiles.field517[rotation], var19, var21);
		}
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(CI)Z",
		garbageValue = "81197967"
	)
	@Export("isAlphaNumeric")
	public static boolean isAlphaNumeric(char var0) {
		return var0 >= '0' && var0 <= '9' || var0 >= 'A' && var0 <= 'Z' || var0 >= 'a' && var0 <= 'z';
	}
}
