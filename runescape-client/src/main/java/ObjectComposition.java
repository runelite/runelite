import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jj")
@Implements("ObjectComposition")
public class ObjectComposition extends CacheableNode {
   @ObfuscatedName("m")
   public static boolean field3530;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lik;"
   )
   @Export("objects_ref")
   public static IndexDataBase objects_ref;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lik;"
   )
   public static IndexDataBase field3488;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lgr;"
   )
   @Export("objects")
   public static NodeCache objects;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lgr;"
   )
   public static NodeCache field3490;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lgr;"
   )
   @Export("cachedModels")
   public static NodeCache cachedModels;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lgr;"
   )
   public static NodeCache field3489;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "[Ldv;"
   )
   static ModelData[] field3493;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 421288767
   )
   @Export("id")
   public int id;
   @ObfuscatedName("n")
   @Export("objectModels")
   int[] objectModels;
   @ObfuscatedName("c")
   @Export("objectTypes")
   int[] objectTypes;
   @ObfuscatedName("a")
   @Export("name")
   public String name;
   @ObfuscatedName("y")
   @Export("recolorToFind")
   short[] recolorToFind;
   @ObfuscatedName("w")
   @Export("recolorToReplace")
   short[] recolorToReplace;
   @ObfuscatedName("k")
   @Export("textureToFind")
   short[] textureToFind;
   @ObfuscatedName("t")
   @Export("textureToReplace")
   short[] textureToReplace;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -178129945
   )
   @Export("sizeX")
   public int sizeX;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 386099589
   )
   @Export("sizeY")
   public int sizeY;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1815895053
   )
   @Export("interactType")
   public int interactType;
   @ObfuscatedName("g")
   public boolean field3505;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -2131012727
   )
   public int field3506;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1245833351
   )
   @Export("clipType")
   int clipType;
   @ObfuscatedName("d")
   @Export("nonFlatShading")
   boolean nonFlatShading;
   @ObfuscatedName("s")
   @Export("modelClipped")
   public boolean modelClipped;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1443740959
   )
   @Export("animationId")
   public int animationId;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -666226443
   )
   public int field3491;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = -735247921
   )
   @Export("ambient")
   int ambient;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -29553565
   )
   @Export("contrast")
   int contrast;
   @ObfuscatedName("aq")
   @Export("actions")
   public String[] actions;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = 968530377
   )
   @Export("mapIconId")
   public int mapIconId;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = 502946603
   )
   @Export("mapSceneId")
   public int mapSceneId;
   @ObfuscatedName("ag")
   @Export("isRotated")
   boolean isRotated;
   @ObfuscatedName("ap")
   @Export("clipped")
   public boolean clipped;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = 2080051843
   )
   @Export("modelSizeX")
   int modelSizeX;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = 41975551
   )
   @Export("modelSizeHeight")
   int modelSizeHeight;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = -551328309
   )
   @Export("modelSizeY")
   int modelSizeY;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = -1021863593
   )
   @Export("offsetX")
   int offsetX;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = -1586120365
   )
   @Export("offsetHeight")
   int offsetHeight;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = 518024777
   )
   @Export("offsetY")
   int offsetY;
   @ObfuscatedName("ay")
   public boolean field3525;
   @ObfuscatedName("az")
   @Export("isSolid")
   boolean isSolid;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = 202775941
   )
   public int field3527;
   @ObfuscatedName("au")
   @Export("impostorIds")
   public int[] impostorIds;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = 2069309931
   )
   @Export("varpId")
   int varpId;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = 2011480305
   )
   @Export("configId")
   int configId;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -782666627
   )
   @Export("ambientSoundId")
   public int ambientSoundId;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = -978999517
   )
   public int field3511;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = 97780329
   )
   public int field3533;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = -733792243
   )
   public int field3534;
   @ObfuscatedName("aj")
   public int[] field3535;
   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "Lgd;"
   )
   IterableHashTable field3537;

   static {
      field3530 = false;
      objects = new NodeCache(4096);
      field3490 = new NodeCache(500);
      cachedModels = new NodeCache(30);
      field3489 = new NodeCache(30);
      field3493 = new ModelData[4];
   }

   ObjectComposition() {
      this.name = "null";
      this.sizeX = 1;
      this.sizeY = 1;
      this.interactType = 2;
      this.field3505 = true;
      this.field3506 = -1;
      this.clipType = -1;
      this.nonFlatShading = false;
      this.modelClipped = false;
      this.animationId = -1;
      this.field3491 = 16;
      this.ambient = 0;
      this.contrast = 0;
      this.actions = new String[5];
      this.mapIconId = -1;
      this.mapSceneId = -1;
      this.isRotated = false;
      this.clipped = true;
      this.modelSizeX = 128;
      this.modelSizeHeight = 128;
      this.modelSizeY = 128;
      this.offsetX = 0;
      this.offsetHeight = 0;
      this.offsetY = 0;
      this.field3525 = false;
      this.isSolid = false;
      this.field3527 = -1;
      this.varpId = -1;
      this.configId = -1;
      this.ambientSoundId = -1;
      this.field3511 = 0;
      this.field3533 = 0;
      this.field3534 = 0;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "604082752"
   )
   @Export("post")
   void post() {
      if(this.field3506 == -1) {
         this.field3506 = 0;
         if(this.objectModels != null && (this.objectTypes == null || this.objectTypes[0] == 10)) {
            this.field3506 = 1;
         }

         for(int var1 = 0; var1 < 5; ++var1) {
            if(this.actions[var1] != null) {
               this.field3506 = 1;
            }
         }
      }

      if(this.field3527 == -1) {
         this.field3527 = this.interactType != 0?1:0;
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lfv;I)V",
      garbageValue = "-1816043199"
   )
   @Export("decode")
   void decode(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.loadData(var1, var2);
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lfv;IB)V",
      garbageValue = "3"
   )
   @Export("loadData")
   void loadData(Buffer var1, int var2) {
      int var3;
      int var4;
      if(var2 == 1) {
         var3 = var1.readUnsignedByte();
         if(var3 > 0) {
            if(this.objectModels != null && !field3530) {
               var1.offset += 3 * var3;
            } else {
               this.objectTypes = new int[var3];
               this.objectModels = new int[var3];

               for(var4 = 0; var4 < var3; ++var4) {
                  this.objectModels[var4] = var1.readUnsignedShort();
                  this.objectTypes[var4] = var1.readUnsignedByte();
               }
            }
         }
      } else if(var2 == 2) {
         this.name = var1.readString();
      } else if(var2 == 5) {
         var3 = var1.readUnsignedByte();
         if(var3 > 0) {
            if(this.objectModels != null && !field3530) {
               var1.offset += 2 * var3;
            } else {
               this.objectTypes = null;
               this.objectModels = new int[var3];

               for(var4 = 0; var4 < var3; ++var4) {
                  this.objectModels[var4] = var1.readUnsignedShort();
               }
            }
         }
      } else if(var2 == 14) {
         this.sizeX = var1.readUnsignedByte();
      } else if(var2 == 15) {
         this.sizeY = var1.readUnsignedByte();
      } else if(var2 == 17) {
         this.interactType = 0;
         this.field3505 = false;
      } else if(var2 == 18) {
         this.field3505 = false;
      } else if(var2 == 19) {
         this.field3506 = var1.readUnsignedByte();
      } else if(var2 == 21) {
         this.clipType = 0;
      } else if(var2 == 22) {
         this.nonFlatShading = true;
      } else if(var2 == 23) {
         this.modelClipped = true;
      } else if(var2 == 24) {
         this.animationId = var1.readUnsignedShort();
         if(this.animationId == 65535) {
            this.animationId = -1;
         }
      } else if(var2 == 27) {
         this.interactType = 1;
      } else if(var2 == 28) {
         this.field3491 = var1.readUnsignedByte();
      } else if(var2 == 29) {
         this.ambient = var1.readByte();
      } else if(var2 == 39) {
         this.contrast = var1.readByte() * 25;
      } else if(var2 >= 30 && var2 < 35) {
         this.actions[var2 - 30] = var1.readString();
         if(this.actions[var2 - 30].equalsIgnoreCase("Hidden")) {
            this.actions[var2 - 30] = null;
         }
      } else if(var2 == 40) {
         var3 = var1.readUnsignedByte();
         this.recolorToFind = new short[var3];
         this.recolorToReplace = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.recolorToFind[var4] = (short)var1.readUnsignedShort();
            this.recolorToReplace[var4] = (short)var1.readUnsignedShort();
         }
      } else if(var2 == 41) {
         var3 = var1.readUnsignedByte();
         this.textureToFind = new short[var3];
         this.textureToReplace = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.textureToFind[var4] = (short)var1.readUnsignedShort();
            this.textureToReplace[var4] = (short)var1.readUnsignedShort();
         }
      } else if(var2 == 62) {
         this.isRotated = true;
      } else if(var2 == 64) {
         this.clipped = false;
      } else if(var2 == 65) {
         this.modelSizeX = var1.readUnsignedShort();
      } else if(var2 == 66) {
         this.modelSizeHeight = var1.readUnsignedShort();
      } else if(var2 == 67) {
         this.modelSizeY = var1.readUnsignedShort();
      } else if(var2 == 68) {
         this.mapSceneId = var1.readUnsignedShort();
      } else if(var2 == 69) {
         var1.readUnsignedByte();
      } else if(var2 == 70) {
         this.offsetX = var1.readShort();
      } else if(var2 == 71) {
         this.offsetHeight = var1.readShort();
      } else if(var2 == 72) {
         this.offsetY = var1.readShort();
      } else if(var2 == 73) {
         this.field3525 = true;
      } else if(var2 == 74) {
         this.isSolid = true;
      } else if(var2 == 75) {
         this.field3527 = var1.readUnsignedByte();
      } else if(var2 != 77 && var2 != 92) {
         if(var2 == 78) {
            this.ambientSoundId = var1.readUnsignedShort();
            this.field3511 = var1.readUnsignedByte();
         } else if(var2 == 79) {
            this.field3533 = var1.readUnsignedShort();
            this.field3534 = var1.readUnsignedShort();
            this.field3511 = var1.readUnsignedByte();
            var3 = var1.readUnsignedByte();
            this.field3535 = new int[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field3535[var4] = var1.readUnsignedShort();
            }
         } else if(var2 == 81) {
            this.clipType = var1.readUnsignedByte() * 256;
         } else if(var2 == 82) {
            this.mapIconId = var1.readUnsignedShort();
         } else if(var2 == 249) {
            this.field3537 = Tile.method2607(var1, this.field3537);
         }
      } else {
         this.varpId = var1.readUnsignedShort();
         if(this.varpId == 65535) {
            this.varpId = -1;
         }

         this.configId = var1.readUnsignedShort();
         if(this.configId == 65535) {
            this.configId = -1;
         }

         var3 = -1;
         if(var2 == 92) {
            var3 = var1.readUnsignedShort();
            if(var3 == 65535) {
               var3 = -1;
            }
         }

         var4 = var1.readUnsignedByte();
         this.impostorIds = new int[var4 + 2];

         for(int var5 = 0; var5 <= var4; ++var5) {
            this.impostorIds[var5] = var1.readUnsignedShort();
            if(this.impostorIds[var5] == 65535) {
               this.impostorIds[var5] = -1;
            }
         }

         this.impostorIds[var4 + 1] = var3;
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "981083059"
   )
   public final boolean method4697(int var1) {
      if(this.objectTypes != null) {
         for(int var4 = 0; var4 < this.objectTypes.length; ++var4) {
            if(this.objectTypes[var4] == var1) {
               return field3488.method4281(this.objectModels[var4] & 65535, 0);
            }
         }

         return true;
      } else if(this.objectModels == null) {
         return true;
      } else if(var1 != 10) {
         return true;
      } else {
         boolean var2 = true;

         for(int var3 = 0; var3 < this.objectModels.length; ++var3) {
            var2 &= field3488.method4281(this.objectModels[var3] & 65535, 0);
         }

         return var2;
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "0"
   )
   public final boolean method4698() {
      if(this.objectModels == null) {
         return true;
      } else {
         boolean var1 = true;

         for(int var2 = 0; var2 < this.objectModels.length; ++var2) {
            var1 &= field3488.method4281(this.objectModels[var2] & 65535, 0);
         }

         return var1;
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II[[IIIII)Lei;",
      garbageValue = "2022838026"
   )
   @Export("getModel")
   public final Renderable getModel(int var1, int var2, int[][] var3, int var4, int var5, int var6) {
      long var7;
      if(this.objectTypes == null) {
         var7 = (long)(var2 + (this.id << 10));
      } else {
         var7 = (long)(var2 + (var1 << 3) + (this.id << 10));
      }

      Object var9 = (Renderable)cachedModels.get(var7);
      if(var9 == null) {
         ModelData var10 = this.getModel(var1, var2);
         if(var10 == null) {
            return null;
         }

         if(!this.nonFlatShading) {
            var9 = var10.light(this.ambient + 64, this.contrast + 768, -50, -10, -50);
         } else {
            var10.field1749 = (short)(this.ambient + 64);
            var10.contrast = (short)(this.contrast + 768);
            var10.computeNormals();
            var9 = var10;
         }

         cachedModels.put((CacheableNode)var9, var7);
      }

      if(this.nonFlatShading) {
         var9 = ((ModelData)var9).method2552();
      }

      if(this.clipType >= 0) {
         if(var9 instanceof Model) {
            var9 = ((Model)var9).method2611(var3, var4, var5, var6, true, this.clipType);
         } else if(var9 instanceof ModelData) {
            var9 = ((ModelData)var9).method2528(var3, var4, var5, var6, true, this.clipType);
         }
      }

      return (Renderable)var9;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(II[[IIIII)Len;",
      garbageValue = "2087024196"
   )
   public final Model method4700(int var1, int var2, int[][] var3, int var4, int var5, int var6) {
      long var7;
      if(this.objectTypes == null) {
         var7 = (long)(var2 + (this.id << 10));
      } else {
         var7 = (long)(var2 + (var1 << 3) + (this.id << 10));
      }

      Model var9 = (Model)field3489.get(var7);
      if(var9 == null) {
         ModelData var10 = this.getModel(var1, var2);
         if(var10 == null) {
            return null;
         }

         var9 = var10.light(this.ambient + 64, this.contrast + 768, -50, -10, -50);
         field3489.put(var9, var7);
      }

      if(this.clipType >= 0) {
         var9 = var9.method2611(var3, var4, var5, var6, true, this.clipType);
      }

      return var9;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(II[[IIIILjf;II)Len;",
      garbageValue = "1189251748"
   )
   public final Model method4693(int var1, int var2, int[][] var3, int var4, int var5, int var6, Sequence var7, int var8) {
      long var9;
      if(this.objectTypes == null) {
         var9 = (long)(var2 + (this.id << 10));
      } else {
         var9 = (long)(var2 + (var1 << 3) + (this.id << 10));
      }

      Model var11 = (Model)field3489.get(var9);
      if(var11 == null) {
         ModelData var12 = this.getModel(var1, var2);
         if(var12 == null) {
            return null;
         }

         var11 = var12.light(this.ambient + 64, this.contrast + 768, -50, -10, -50);
         field3489.put(var11, var9);
      }

      if(var7 == null && this.clipType == -1) {
         return var11;
      } else {
         if(var7 != null) {
            var11 = var7.method4878(var11, var8, var2);
         } else {
            var11 = var11.method2640(true);
         }

         if(this.clipType >= 0) {
            var11 = var11.method2611(var3, var4, var5, var6, false, this.clipType);
         }

         return var11;
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(III)Ldv;",
      garbageValue = "2040746543"
   )
   @Export("getModel")
   final ModelData getModel(int var1, int var2) {
      ModelData var3 = null;
      boolean var4;
      int var5;
      int var7;
      if(this.objectTypes == null) {
         if(var1 != 10) {
            return null;
         }

         if(this.objectModels == null) {
            return null;
         }

         var4 = this.isRotated;
         if(var1 == 2 && var2 > 3) {
            var4 = !var4;
         }

         var5 = this.objectModels.length;

         for(int var6 = 0; var6 < var5; ++var6) {
            var7 = this.objectModels[var6];
            if(var4) {
               var7 += 65536;
            }

            var3 = (ModelData)field3490.get((long)var7);
            if(var3 == null) {
               var3 = ModelData.method2533(field3488, var7 & 65535, 0);
               if(var3 == null) {
                  return null;
               }

               if(var4) {
                  var3.method2561();
               }

               field3490.put(var3, (long)var7);
            }

            if(var5 > 1) {
               field3493[var6] = var3;
            }
         }

         if(var5 > 1) {
            var3 = new ModelData(field3493, var5);
         }
      } else {
         int var9 = -1;

         for(var5 = 0; var5 < this.objectTypes.length; ++var5) {
            if(this.objectTypes[var5] == var1) {
               var9 = var5;
               break;
            }
         }

         if(var9 == -1) {
            return null;
         }

         var5 = this.objectModels[var9];
         boolean var10 = this.isRotated ^ var2 > 3;
         if(var10) {
            var5 += 65536;
         }

         var3 = (ModelData)field3490.get((long)var5);
         if(var3 == null) {
            var3 = ModelData.method2533(field3488, var5 & 65535, 0);
            if(var3 == null) {
               return null;
            }

            if(var10) {
               var3.method2561();
            }

            field3490.put(var3, (long)var5);
         }
      }

      if(this.modelSizeX == 128 && this.modelSizeHeight == 128 && this.modelSizeY == 128) {
         var4 = false;
      } else {
         var4 = true;
      }

      boolean var11;
      if(this.offsetX == 0 && this.offsetHeight == 0 && this.offsetY == 0) {
         var11 = false;
      } else {
         var11 = true;
      }

      ModelData var8 = new ModelData(var3, var2 == 0 && !var4 && !var11, this.recolorToFind == null, null == this.textureToFind, true);
      if(var1 == 4 && var2 > 3) {
         var8.method2594(256);
         var8.method2576(45, 0, -45);
      }

      var2 &= 3;
      if(var2 == 1) {
         var8.method2530();
      } else if(var2 == 2) {
         var8.method2556();
      } else if(var2 == 3) {
         var8.method2540();
      }

      if(this.recolorToFind != null) {
         for(var7 = 0; var7 < this.recolorToFind.length; ++var7) {
            var8.recolor(this.recolorToFind[var7], this.recolorToReplace[var7]);
         }
      }

      if(this.textureToFind != null) {
         for(var7 = 0; var7 < this.textureToFind.length; ++var7) {
            var8.method2536(this.textureToFind[var7], this.textureToReplace[var7]);
         }
      }

      if(var4) {
         var8.method2587(this.modelSizeX, this.modelSizeHeight, this.modelSizeY);
      }

      if(var11) {
         var8.method2576(this.offsetX, this.offsetHeight, this.offsetY);
      }

      return var8;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)Ljj;",
      garbageValue = "1890728937"
   )
   @Export("getImpostor")
   public final ObjectComposition getImpostor() {
      int var1 = -1;
      if(this.varpId != -1) {
         var1 = Item.method1849(this.varpId);
      } else if(this.configId != -1) {
         var1 = class218.widgetSettings[this.configId];
      }

      int var2;
      if(var1 >= 0 && var1 < this.impostorIds.length - 1) {
         var2 = this.impostorIds[var1];
      } else {
         var2 = this.impostorIds[this.impostorIds.length - 1];
      }

      return var2 != -1?class24.getObjectDefinition(var2):null;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "522969576"
   )
   public int method4714(int var1, int var2) {
      return Occluder.method2998(this.field3537, var1, var2);
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)Ljava/lang/String;",
      garbageValue = "-861861961"
   )
   public String method4705(int var1, String var2) {
      return VertexNormal.method2702(this.field3537, var1, var2);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "0"
   )
   public boolean method4706() {
      if(this.impostorIds == null) {
         return this.ambientSoundId != -1 || this.field3535 != null;
      } else {
         for(int var1 = 0; var1 < this.impostorIds.length; ++var1) {
            if(this.impostorIds[var1] != -1) {
               ObjectComposition var2 = class24.getObjectDefinition(this.impostorIds[var1]);
               if(var2.ambientSoundId != -1 || var2.field3535 != null) {
                  return true;
               }
            }
         }

         return false;
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)[Lkd;",
      garbageValue = "-101"
   )
   static SpritePixels[] method4701() {
      SpritePixels[] var0 = new SpritePixels[class295.field3854];

      for(int var1 = 0; var1 < class295.field3854; ++var1) {
         SpritePixels var2 = var0[var1] = new SpritePixels();
         var2.maxWidth = class295.field3850;
         var2.maxHeight = class295.field3851;
         var2.offsetX = class295.field3853[var1];
         var2.offsetY = class37.offsetsY[var1];
         var2.width = ItemContainer.field745[var1];
         var2.height = class31.field428[var1];
         int var3 = var2.height * var2.width;
         byte[] var4 = class295.spritePixels[var1];
         var2.pixels = new int[var3];

         for(int var5 = 0; var5 < var3; ++var5) {
            var2.pixels[var5] = class295.field3852[var4[var5] & 255];
         }
      }

      class276.method5044();
      return var0;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Ljava/lang/String;",
      garbageValue = "-2140017105"
   )
   public static String method4745(String var0) {
      int var1 = var0.length();
      char[] var2 = new char[var1];
      byte var3 = 2;

      for(int var4 = 0; var4 < var1; ++var4) {
         char var5 = var0.charAt(var4);
         if(var3 == 0) {
            var5 = Character.toLowerCase(var5);
         } else if(var3 == 2 || Character.isUpperCase(var5)) {
            var5 = class40.method595(var5);
         }

         if(Character.isLetter(var5)) {
            var3 = 0;
         } else if(var5 != '.' && var5 != '?' && var5 != '!') {
            if(Character.isSpaceChar(var5)) {
               if(var3 != 2) {
                  var3 = 1;
               }
            } else {
               var3 = 1;
            }
         } else {
            var3 = 2;
         }

         var2[var4] = var5;
      }

      return new String(var2);
   }
}
