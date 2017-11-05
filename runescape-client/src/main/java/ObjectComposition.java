import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iv")
@Implements("ObjectComposition")
public class ObjectComposition extends CacheableNode {
   @ObfuscatedName("w")
   static boolean field3455;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lip;"
   )
   @Export("objects_ref")
   static IndexDataBase objects_ref;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lip;"
   )
   static IndexDataBase field3436;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lgo;"
   )
   @Export("objects")
   public static NodeCache objects;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lgo;"
   )
   public static NodeCache field3438;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lgo;"
   )
   @Export("cachedModels")
   public static NodeCache cachedModels;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lgo;"
   )
   public static NodeCache field3440;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "[Ldo;"
   )
   static ModelData[] field3441;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 2104460175
   )
   @Export("id")
   public int id;
   @ObfuscatedName("x")
   @Export("objectModels")
   int[] objectModels;
   @ObfuscatedName("z")
   @Export("objectTypes")
   int[] objectTypes;
   @ObfuscatedName("n")
   @Export("name")
   public String name;
   @ObfuscatedName("u")
   @Export("recolorToFind")
   short[] recolorToFind;
   @ObfuscatedName("t")
   @Export("recolorToReplace")
   short[] recolorToReplace;
   @ObfuscatedName("a")
   @Export("textureToFind")
   short[] textureToFind;
   @ObfuscatedName("i")
   @Export("textureToReplace")
   short[] textureToReplace;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1900597893
   )
   @Export("sizeX")
   public int sizeX;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -552920239
   )
   @Export("sizeY")
   public int sizeY;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 689937999
   )
   @Export("interactType")
   public int interactType;
   @ObfuscatedName("y")
   public boolean field3453;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1088175929
   )
   public int field3454;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -996065169
   )
   @Export("clipType")
   int clipType;
   @ObfuscatedName("r")
   @Export("nonFlatShading")
   boolean nonFlatShading;
   @ObfuscatedName("m")
   @Export("modelClipped")
   public boolean modelClipped;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 2058939521
   )
   @Export("animationId")
   public int animationId;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 802198573
   )
   public int field3474;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = 1415256129
   )
   @Export("ambient")
   int ambient;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = 1036291921
   )
   @Export("contrast")
   int contrast;
   @ObfuscatedName("aa")
   @Export("actions")
   public String[] actions;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = 491644703
   )
   @Export("mapIconId")
   public int mapIconId;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = -1368051167
   )
   @Export("mapSceneId")
   public int mapSceneId;
   @ObfuscatedName("az")
   @Export("isRotated")
   boolean isRotated;
   @ObfuscatedName("at")
   @Export("clipped")
   public boolean clipped;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = 660408737
   )
   @Export("modelSizeX")
   int modelSizeX;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = -1720699733
   )
   @Export("modelSizeHeight")
   int modelSizeHeight;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = 75051289
   )
   @Export("modelSizeY")
   int modelSizeY;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = 286053825
   )
   @Export("offsetX")
   int offsetX;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = -43849717
   )
   @Export("offsetHeight")
   int offsetHeight;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 877141417
   )
   @Export("offsetY")
   int offsetY;
   @ObfuscatedName("ab")
   public boolean field3473;
   @ObfuscatedName("aj")
   @Export("isSolid")
   boolean isSolid;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = 1587865223
   )
   public int field3475;
   @ObfuscatedName("ad")
   @Export("impostorIds")
   public int[] impostorIds;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = 1926117107
   )
   @Export("varpId")
   int varpId;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = 1396474829
   )
   @Export("configId")
   int configId;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = 1691262027
   )
   @Export("ambientSoundId")
   public int ambientSoundId;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = -19622607
   )
   public int field3480;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = -862987309
   )
   public int field3443;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = -1311245325
   )
   public int field3458;
   @ObfuscatedName("au")
   public int[] field3483;
   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "Lgk;"
   )
   IterableHashTable field3484;

   static {
      field3455 = false;
      objects = new NodeCache(4096);
      field3438 = new NodeCache(500);
      cachedModels = new NodeCache(30);
      field3440 = new NodeCache(30);
      field3441 = new ModelData[4];
   }

   ObjectComposition() {
      this.name = "null";
      this.sizeX = 1;
      this.sizeY = 1;
      this.interactType = 2;
      this.field3453 = true;
      this.field3454 = -1;
      this.clipType = -1;
      this.nonFlatShading = false;
      this.modelClipped = false;
      this.animationId = -1;
      this.field3474 = 16;
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
      this.field3473 = false;
      this.isSolid = false;
      this.field3475 = -1;
      this.varpId = -1;
      this.configId = -1;
      this.ambientSoundId = -1;
      this.field3480 = 0;
      this.field3443 = 0;
      this.field3458 = 0;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1157182724"
   )
   @Export("post")
   void post() {
      if(this.field3454 == -1) {
         this.field3454 = 0;
         if(this.objectModels != null && (this.objectTypes == null || this.objectTypes[0] == 10)) {
            this.field3454 = 1;
         }

         for(int var1 = 0; var1 < 5; ++var1) {
            if(this.actions[var1] != null) {
               this.field3454 = 1;
            }
         }
      }

      if(this.field3475 == -1) {
         this.field3475 = this.interactType != 0?1:0;
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lfz;I)V",
      garbageValue = "-1042819185"
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

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lfz;IB)V",
      garbageValue = "82"
   )
   @Export("loadData")
   void loadData(Buffer var1, int var2) {
      int var3;
      int var4;
      if(var2 == 1) {
         var3 = var1.readUnsignedByte();
         if(var3 > 0) {
            if(this.objectModels != null && !field3455) {
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
            if(this.objectModels != null && !field3455) {
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
         this.field3453 = false;
      } else if(var2 == 18) {
         this.field3453 = false;
      } else if(var2 == 19) {
         this.field3454 = var1.readUnsignedByte();
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
         this.field3474 = var1.readUnsignedByte();
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
         this.field3473 = true;
      } else if(var2 == 74) {
         this.isSolid = true;
      } else if(var2 == 75) {
         this.field3475 = var1.readUnsignedByte();
      } else if(var2 != 77 && var2 != 92) {
         if(var2 == 78) {
            this.ambientSoundId = var1.readUnsignedShort();
            this.field3480 = var1.readUnsignedByte();
         } else if(var2 == 79) {
            this.field3443 = var1.readUnsignedShort();
            this.field3458 = var1.readUnsignedShort();
            this.field3480 = var1.readUnsignedByte();
            var3 = var1.readUnsignedByte();
            this.field3483 = new int[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field3483[var4] = var1.readUnsignedShort();
            }
         } else if(var2 == 81) {
            this.clipType = var1.readUnsignedByte() * 256;
         } else if(var2 == 82) {
            this.mapIconId = var1.readUnsignedShort();
         } else if(var2 == 249) {
            this.field3484 = FileOnDisk.method2427(var1, this.field3484);
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
      signature = "(IB)Z",
      garbageValue = "0"
   )
   public final boolean method4630(int var1) {
      if(this.objectTypes != null) {
         for(int var4 = 0; var4 < this.objectTypes.length; ++var4) {
            if(this.objectTypes[var4] == var1) {
               return field3436.method4192(this.objectModels[var4] & 65535, 0);
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
            var2 &= field3436.method4192(this.objectModels[var3] & 65535, 0);
         }

         return var2;
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1933861568"
   )
   public final boolean method4604() {
      if(this.objectModels == null) {
         return true;
      } else {
         boolean var1 = true;

         for(int var2 = 0; var2 < this.objectModels.length; ++var2) {
            var1 &= field3436.method4192(this.objectModels[var2] & 65535, 0);
         }

         return var1;
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II[[IIIII)Len;",
      garbageValue = "-900846656"
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
            var10.field1816 = (short)(this.ambient + 64);
            var10.contrast = (short)(this.contrast + 768);
            var10.computeNormals();
            var9 = var10;
         }

         cachedModels.put((CacheableNode)var9, var7);
      }

      if(this.nonFlatShading) {
         var9 = ((ModelData)var9).method2504();
      }

      if(this.clipType >= 0) {
         if(var9 instanceof Model) {
            var9 = ((Model)var9).method2579(var3, var4, var5, var6, true, this.clipType);
         } else if(var9 instanceof ModelData) {
            var9 = ((ModelData)var9).method2460(var3, var4, var5, var6, true, this.clipType);
         }
      }

      return (Renderable)var9;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II[[IIIII)Leh;",
      garbageValue = "613646316"
   )
   public final Model method4606(int var1, int var2, int[][] var3, int var4, int var5, int var6) {
      long var7;
      if(this.objectTypes == null) {
         var7 = (long)(var2 + (this.id << 10));
      } else {
         var7 = (long)(var2 + (var1 << 3) + (this.id << 10));
      }

      Model var9 = (Model)field3440.get(var7);
      if(var9 == null) {
         ModelData var10 = this.getModel(var1, var2);
         if(var10 == null) {
            return null;
         }

         var9 = var10.light(this.ambient + 64, this.contrast + 768, -50, -10, -50);
         field3440.put(var9, var7);
      }

      if(this.clipType >= 0) {
         var9 = var9.method2579(var3, var4, var5, var6, true, this.clipType);
      }

      return var9;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II[[IIIILjt;II)Leh;",
      garbageValue = "-1385953298"
   )
   public final Model method4641(int var1, int var2, int[][] var3, int var4, int var5, int var6, Sequence var7, int var8) {
      long var9;
      if(this.objectTypes == null) {
         var9 = (long)(var2 + (this.id << 10));
      } else {
         var9 = (long)(var2 + (var1 << 3) + (this.id << 10));
      }

      Model var11 = (Model)field3440.get(var9);
      if(var11 == null) {
         ModelData var12 = this.getModel(var1, var2);
         if(var12 == null) {
            return null;
         }

         var11 = var12.light(this.ambient + 64, this.contrast + 768, -50, -10, -50);
         field3440.put(var11, var9);
      }

      if(var7 == null && this.clipType == -1) {
         return var11;
      } else {
         if(var7 != null) {
            var11 = var7.method4782(var11, var8, var2);
         } else {
            var11 = var11.method2628(true);
         }

         if(this.clipType >= 0) {
            var11 = var11.method2579(var3, var4, var5, var6, false, this.clipType);
         }

         return var11;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(III)Ldo;",
      garbageValue = "773117396"
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

            var3 = (ModelData)field3438.get((long)var7);
            if(var3 == null) {
               var3 = ModelData.method2534(field3436, var7 & 65535, 0);
               if(var3 == null) {
                  return null;
               }

               if(var4) {
                  var3.method2469();
               }

               field3438.put(var3, (long)var7);
            }

            if(var5 > 1) {
               field3441[var6] = var3;
            }
         }

         if(var5 > 1) {
            var3 = new ModelData(field3441, var5);
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

         var3 = (ModelData)field3438.get((long)var5);
         if(var3 == null) {
            var3 = ModelData.method2534(field3436, var5 & 65535, 0);
            if(var3 == null) {
               return null;
            }

            if(var10) {
               var3.method2469();
            }

            field3438.put(var3, (long)var5);
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
         var8.method2465(256);
         var8.method2463(45, 0, -45);
      }

      var2 &= 3;
      if(var2 == 1) {
         var8.method2462();
      } else if(var2 == 2) {
         var8.method2474();
      } else if(var2 == 3) {
         var8.method2464();
      }

      if(this.recolorToFind != null) {
         for(var7 = 0; var7 < this.recolorToFind.length; ++var7) {
            var8.recolor(this.recolorToFind[var7], this.recolorToReplace[var7]);
         }
      }

      if(this.textureToFind != null) {
         for(var7 = 0; var7 < this.textureToFind.length; ++var7) {
            var8.method2495(this.textureToFind[var7], this.textureToReplace[var7]);
         }
      }

      if(var4) {
         var8.method2470(this.modelSizeX, this.modelSizeHeight, this.modelSizeY);
      }

      if(var11) {
         var8.method2463(this.offsetX, this.offsetHeight, this.offsetY);
      }

      return var8;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)Liv;",
      garbageValue = "2110056604"
   )
   @Export("getImpostor")
   public final ObjectComposition getImpostor() {
      int var1 = -1;
      if(this.varpId != -1) {
         var1 = class89.method1732(this.varpId);
      } else if(this.configId != -1) {
         var1 = class211.widgetSettings[this.configId];
      }

      int var2;
      if(var1 >= 0 && var1 < this.impostorIds.length - 1) {
         var2 = this.impostorIds[var1];
      } else {
         var2 = this.impostorIds[this.impostorIds.length - 1];
      }

      return var2 != -1?CollisionData.getObjectDefinition(var2):null;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "589804910"
   )
   public int method4625(int var1, int var2) {
      return class227.method4159(this.field3484, var1, var2);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)Ljava/lang/String;",
      garbageValue = "98824363"
   )
   public String method4624(int var1, String var2) {
      return class204.method3902(this.field3484, var1, var2);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1077971233"
   )
   public boolean method4610() {
      if(this.impostorIds == null) {
         return this.ambientSoundId != -1 || this.field3483 != null;
      } else {
         for(int var1 = 0; var1 < this.impostorIds.length; ++var1) {
            if(this.impostorIds[var1] != -1) {
               ObjectComposition var2 = CollisionData.getObjectDefinition(this.impostorIds[var1]);
               if(var2.ambientSoundId != -1 || var2.field3483 != null) {
                  return true;
               }
            }
         }

         return false;
      }
   }
}
