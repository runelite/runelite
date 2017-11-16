import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jt")
@Implements("ObjectComposition")
public class ObjectComposition extends CacheableNode {
   @ObfuscatedName("b")
   static boolean field3526;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lij;"
   )
   @Export("objects_ref")
   static IndexDataBase objects_ref;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lij;"
   )
   static IndexDataBase field3487;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lgp;"
   )
   @Export("objects")
   public static NodeCache objects;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lgp;"
   )
   public static NodeCache field3489;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lgp;"
   )
   @Export("cachedModels")
   public static NodeCache cachedModels;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lgp;"
   )
   public static NodeCache field3491;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "[Lda;"
   )
   static ModelData[] field3492;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -2006742663
   )
   @Export("id")
   public int id;
   @ObfuscatedName("n")
   @Export("objectModels")
   int[] objectModels;
   @ObfuscatedName("d")
   @Export("objectTypes")
   int[] objectTypes;
   @ObfuscatedName("o")
   @Export("name")
   public String name;
   @ObfuscatedName("a")
   @Export("recolorToFind")
   short[] recolorToFind;
   @ObfuscatedName("q")
   @Export("recolorToReplace")
   short[] recolorToReplace;
   @ObfuscatedName("j")
   @Export("textureToFind")
   short[] textureToFind;
   @ObfuscatedName("m")
   @Export("textureToReplace")
   short[] textureToReplace;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1565780915
   )
   @Export("sizeX")
   public int sizeX;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 2096323971
   )
   @Export("sizeY")
   public int sizeY;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1193087359
   )
   @Export("interactType")
   public int interactType;
   @ObfuscatedName("p")
   public boolean field3504;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1652203691
   )
   public int field3486;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1081393943
   )
   @Export("clipType")
   int clipType;
   @ObfuscatedName("z")
   @Export("nonFlatShading")
   boolean nonFlatShading;
   @ObfuscatedName("e")
   @Export("modelClipped")
   public boolean modelClipped;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 588782585
   )
   @Export("animationId")
   public int animationId;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1552925043
   )
   public int field3515;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = 733450893
   )
   @Export("ambient")
   int ambient;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = -1844250817
   )
   @Export("contrast")
   int contrast;
   @ObfuscatedName("ae")
   @Export("actions")
   public String[] actions;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = 378945641
   )
   @Export("mapIconId")
   public int mapIconId;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = -653613089
   )
   @Export("mapSceneId")
   public int mapSceneId;
   @ObfuscatedName("an")
   @Export("isRotated")
   boolean isRotated;
   @ObfuscatedName("am")
   @Export("clipped")
   public boolean clipped;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = -76768607
   )
   @Export("modelSizeX")
   int modelSizeX;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -1944393147
   )
   @Export("modelSizeHeight")
   int modelSizeHeight;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = 1339569233
   )
   @Export("modelSizeY")
   int modelSizeY;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = 1889564649
   )
   @Export("offsetX")
   int offsetX;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = 1875366889
   )
   @Export("offsetHeight")
   int offsetHeight;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = -1742898691
   )
   @Export("offsetY")
   int offsetY;
   @ObfuscatedName("aw")
   public boolean field3524;
   @ObfuscatedName("al")
   @Export("isSolid")
   boolean isSolid;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = 936757635
   )
   public int field3521;
   @ObfuscatedName("ap")
   @Export("impostorIds")
   public int[] impostorIds;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = -1838665519
   )
   @Export("varpId")
   int varpId;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = -475266765
   )
   @Export("configId")
   int configId;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = -939858861
   )
   @Export("ambientSoundId")
   public int ambientSoundId;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = 778839051
   )
   public int field3531;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -1874372385
   )
   public int field3503;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = -1262447695
   )
   public int field3533;
   @ObfuscatedName("az")
   public int[] field3532;
   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "Lgu;"
   )
   IterableHashTable field3535;

   static {
      field3526 = false;
      objects = new NodeCache(4096);
      field3489 = new NodeCache(500);
      cachedModels = new NodeCache(30);
      field3491 = new NodeCache(30);
      field3492 = new ModelData[4];
   }

   ObjectComposition() {
      this.name = "null";
      this.sizeX = 1;
      this.sizeY = 1;
      this.interactType = 2;
      this.field3504 = true;
      this.field3486 = -1;
      this.clipType = -1;
      this.nonFlatShading = false;
      this.modelClipped = false;
      this.animationId = -1;
      this.field3515 = 16;
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
      this.field3524 = false;
      this.isSolid = false;
      this.field3521 = -1;
      this.varpId = -1;
      this.configId = -1;
      this.ambientSoundId = -1;
      this.field3531 = 0;
      this.field3503 = 0;
      this.field3533 = 0;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   @Export("post")
   void post() {
      if(this.field3486 == -1) {
         this.field3486 = 0;
         if(this.objectModels != null && (this.objectTypes == null || this.objectTypes[0] == 10)) {
            this.field3486 = 1;
         }

         for(int var1 = 0; var1 < 5; ++var1) {
            if(this.actions[var1] != null) {
               this.field3486 = 1;
            }
         }
      }

      if(this.field3521 == -1) {
         this.field3521 = this.interactType != 0?1:0;
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lfs;I)V",
      garbageValue = "882144010"
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

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lfs;II)V",
      garbageValue = "184756908"
   )
   @Export("loadData")
   void loadData(Buffer var1, int var2) {
      int var3;
      int var4;
      if(var2 == 1) {
         var3 = var1.readUnsignedByte();
         if(var3 > 0) {
            if(this.objectModels != null && !field3526) {
               var1.offset += var3 * 3;
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
            if(this.objectModels != null && !field3526) {
               var1.offset += var3 * 2;
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
         this.field3504 = false;
      } else if(var2 == 18) {
         this.field3504 = false;
      } else if(var2 == 19) {
         this.field3486 = var1.readUnsignedByte();
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
         this.field3515 = var1.readUnsignedByte();
      } else if(var2 == 29) {
         this.ambient = var1.readByte();
      } else if(var2 == 39) {
         this.contrast = var1.readByte();
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
         this.field3524 = true;
      } else if(var2 == 74) {
         this.isSolid = true;
      } else if(var2 == 75) {
         this.field3521 = var1.readUnsignedByte();
      } else if(var2 != 77 && var2 != 92) {
         if(var2 == 78) {
            this.ambientSoundId = var1.readUnsignedShort();
            this.field3531 = var1.readUnsignedByte();
         } else if(var2 == 79) {
            this.field3503 = var1.readUnsignedShort();
            this.field3533 = var1.readUnsignedShort();
            this.field3531 = var1.readUnsignedByte();
            var3 = var1.readUnsignedByte();
            this.field3532 = new int[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field3532[var4] = var1.readUnsignedShort();
            }
         } else if(var2 == 81) {
            this.clipType = var1.readUnsignedByte() * 256;
         } else if(var2 == 82) {
            this.mapIconId = var1.readUnsignedShort();
         } else if(var2 == 249) {
            this.field3535 = class27.method203(var1, this.field3535);
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

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-1507639375"
   )
   public final boolean method4515(int var1) {
      if(this.objectTypes != null) {
         for(int var4 = 0; var4 < this.objectTypes.length; ++var4) {
            if(this.objectTypes[var4] == var1) {
               return field3487.method4157(this.objectModels[var4] & 65535, 0);
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
            var2 &= field3487.method4157(this.objectModels[var3] & 65535, 0);
         }

         return var2;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1582838312"
   )
   public final boolean method4547() {
      if(this.objectModels == null) {
         return true;
      } else {
         boolean var1 = true;

         for(int var2 = 0; var2 < this.objectModels.length; ++var2) {
            var1 &= field3487.method4157(this.objectModels[var2] & 65535, 0);
         }

         return var1;
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(II[[IIIII)Leu;",
      garbageValue = "2014048503"
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
            var9 = var10.light(this.ambient + 64, this.contrast * 25 + 768, -50, -10, -50);
         } else {
            var10.field1740 = (short)(this.ambient + 64);
            var10.contrast = (short)(this.contrast * 25 + 768);
            var10.computeNormals();
            var9 = var10;
         }

         cachedModels.put((CacheableNode)var9, var7);
      }

      if(this.nonFlatShading) {
         var9 = ((ModelData)var9).method2423();
      }

      if(this.clipType >= 0) {
         if(var9 instanceof Model) {
            var9 = ((Model)var9).method2506(var3, var4, var5, var6, true, this.clipType);
         } else if(var9 instanceof ModelData) {
            var9 = ((ModelData)var9).method2424(var3, var4, var5, var6, true, this.clipType);
         }
      }

      return (Renderable)var9;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II[[IIIII)Lev;",
      garbageValue = "580379653"
   )
   public final Model method4545(int var1, int var2, int[][] var3, int var4, int var5, int var6) {
      long var7;
      if(this.objectTypes == null) {
         var7 = (long)(var2 + (this.id << 10));
      } else {
         var7 = (long)(var2 + (var1 << 3) + (this.id << 10));
      }

      Model var9 = (Model)field3491.get(var7);
      if(var9 == null) {
         ModelData var10 = this.getModel(var1, var2);
         if(var10 == null) {
            return null;
         }

         var9 = var10.light(this.ambient + 64, this.contrast * 25 + 768, -50, -10, -50);
         field3491.put(var9, var7);
      }

      if(this.clipType >= 0) {
         var9 = var9.method2506(var3, var4, var5, var6, true, this.clipType);
      }

      return var9;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II[[IIIILjh;II)Lev;",
      garbageValue = "-576751161"
   )
   public final Model method4518(int var1, int var2, int[][] var3, int var4, int var5, int var6, Sequence var7, int var8) {
      long var9;
      if(this.objectTypes == null) {
         var9 = (long)(var2 + (this.id << 10));
      } else {
         var9 = (long)(var2 + (var1 << 3) + (this.id << 10));
      }

      Model var11 = (Model)field3491.get(var9);
      if(var11 == null) {
         ModelData var12 = this.getModel(var1, var2);
         if(var12 == null) {
            return null;
         }

         var11 = var12.light(this.ambient + 64, this.contrast * 25 + 768, -50, -10, -50);
         field3491.put(var11, var9);
      }

      if(var7 == null && this.clipType == -1) {
         return var11;
      } else {
         if(var7 != null) {
            var11 = var7.method4702(var11, var8, var2);
         } else {
            var11 = var11.method2567(true);
         }

         if(this.clipType >= 0) {
            var11 = var11.method2506(var3, var4, var5, var6, false, this.clipType);
         }

         return var11;
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIB)Lda;",
      garbageValue = "-108"
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

            var3 = (ModelData)field3489.get((long)var7);
            if(var3 == null) {
               var3 = ModelData.method2419(field3487, var7 & 65535, 0);
               if(var3 == null) {
                  return null;
               }

               if(var4) {
                  var3.method2433();
               }

               field3489.put(var3, (long)var7);
            }

            if(var5 > 1) {
               field3492[var6] = var3;
            }
         }

         if(var5 > 1) {
            var3 = new ModelData(field3492, var5);
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

         var3 = (ModelData)field3489.get((long)var5);
         if(var3 == null) {
            var3 = ModelData.method2419(field3487, var5 & 65535, 0);
            if(var3 == null) {
               return null;
            }

            if(var10) {
               var3.method2433();
            }

            field3489.put(var3, (long)var5);
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

      ModelData var8 = new ModelData(var3, var2 == 0 && !var4 && !var11, null == this.recolorToFind, null == this.textureToFind, true);
      if(var1 == 4 && var2 > 3) {
         var8.method2429(256);
         var8.method2458(45, 0, -45);
      }

      var2 &= 3;
      if(var2 == 1) {
         var8.method2426();
      } else if(var2 == 2) {
         var8.method2444();
      } else if(var2 == 3) {
         var8.method2428();
      }

      if(this.recolorToFind != null) {
         for(var7 = 0; var7 < this.recolorToFind.length; ++var7) {
            var8.recolor(this.recolorToFind[var7], this.recolorToReplace[var7]);
         }
      }

      if(this.textureToFind != null) {
         for(var7 = 0; var7 < this.textureToFind.length; ++var7) {
            var8.method2432(this.textureToFind[var7], this.textureToReplace[var7]);
         }
      }

      if(var4) {
         var8.method2442(this.modelSizeX, this.modelSizeHeight, this.modelSizeY);
      }

      if(var11) {
         var8.method2458(this.offsetX, this.offsetHeight, this.offsetY);
      }

      return var8;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)Ljt;",
      garbageValue = "-794615135"
   )
   @Export("getImpostor")
   public final ObjectComposition getImpostor() {
      int var1 = -1;
      if(this.varpId != -1) {
         var1 = class18.method131(this.varpId);
      } else if(this.configId != -1) {
         var1 = class218.widgetSettings[this.configId];
      }

      int var2;
      if(var1 >= 0 && var1 < this.impostorIds.length - 1) {
         var2 = this.impostorIds[var1];
      } else {
         var2 = this.impostorIds[this.impostorIds.length - 1];
      }

      return var2 != -1?ClientPacket.getObjectDefinition(var2):null;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-859055480"
   )
   public int method4521(int var1, int var2) {
      return CombatInfo2.method4400(this.field3535, var1, var2);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;S)Ljava/lang/String;",
      garbageValue = "-3645"
   )
   public String method4522(int var1, String var2) {
      return ChatLineBuffer.method1852(this.field3535, var1, var2);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-19"
   )
   public boolean method4539() {
      if(this.impostorIds == null) {
         return this.ambientSoundId != -1 || this.field3532 != null;
      } else {
         for(int var1 = 0; var1 < this.impostorIds.length; ++var1) {
            if(this.impostorIds[var1] != -1) {
               ObjectComposition var2 = ClientPacket.getObjectDefinition(this.impostorIds[var1]);
               if(var2.ambientSoundId != -1 || var2.field3532 != null) {
                  return true;
               }
            }
         }

         return false;
      }
   }
}
