import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jv")
@Implements("ObjectComposition")
public class ObjectComposition extends CacheableNode {
   @ObfuscatedName("d")
   @Export("ObjectDefinition_isLowDetail")
   public static boolean ObjectDefinition_isLowDetail;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lgx;"
   )
   @Export("objects")
   static NodeCache objects;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lgx;"
   )
   public static NodeCache field3502;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lgx;"
   )
   @Export("cachedModels")
   static NodeCache cachedModels;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lgx;"
   )
   static NodeCache field3504;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "[Ldr;"
   )
   static ModelData[] field3526;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 363388191
   )
   @Export("id")
   public int id;
   @ObfuscatedName("r")
   @Export("objectModels")
   int[] objectModels;
   @ObfuscatedName("l")
   @Export("objectTypes")
   int[] objectTypes;
   @ObfuscatedName("u")
   @Export("name")
   public String name;
   @ObfuscatedName("n")
   @Export("recolorToFind")
   short[] recolorToFind;
   @ObfuscatedName("c")
   @Export("recolorToReplace")
   short[] recolorToReplace;
   @ObfuscatedName("y")
   @Export("textureToFind")
   short[] textureToFind;
   @ObfuscatedName("j")
   @Export("textureToReplace")
   short[] textureToReplace;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 630900519
   )
   @Export("sizeX")
   public int sizeX;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -2083754131
   )
   @Export("sizeY")
   public int sizeY;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -687988765
   )
   @Export("interactType")
   public int interactType;
   @ObfuscatedName("q")
   @Export("boolean1")
   public boolean boolean1;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 487037641
   )
   @Export("int1")
   public int int1;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1031362525
   )
   @Export("clipType")
   int clipType;
   @ObfuscatedName("o")
   @Export("nonFlatShading")
   boolean nonFlatShading;
   @ObfuscatedName("w")
   @Export("modelClipped")
   public boolean modelClipped;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -113780837
   )
   @Export("animationId")
   public int animationId;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -194316979
   )
   @Export("int2")
   public int int2;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = 1275812285
   )
   @Export("ambient")
   int ambient;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = 563979869
   )
   @Export("contrast")
   int contrast;
   @ObfuscatedName("aa")
   @Export("actions")
   public String[] actions;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -1608660941
   )
   @Export("mapIconId")
   public int mapIconId;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = -1880512633
   )
   @Export("mapSceneId")
   public int mapSceneId;
   @ObfuscatedName("au")
   @Export("isRotated")
   boolean isRotated;
   @ObfuscatedName("al")
   @Export("clipped")
   public boolean clipped;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = -1064838481
   )
   @Export("modelSizeX")
   int modelSizeX;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = 641800517
   )
   @Export("modelSizeHeight")
   int modelSizeHeight;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = 1415480779
   )
   @Export("modelSizeY")
   int modelSizeY;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = 788682537
   )
   @Export("offsetX")
   int offsetX;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = -1875133581
   )
   @Export("offsetHeight")
   int offsetHeight;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = -1625066149
   )
   @Export("offsetY")
   int offsetY;
   @ObfuscatedName("ap")
   @Export("boolean2")
   public boolean boolean2;
   @ObfuscatedName("ad")
   @Export("isSolid")
   boolean isSolid;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = -1008323081
   )
   @Export("int3")
   public int int3;
   @ObfuscatedName("ai")
   @Export("impostorIds")
   public int[] impostorIds;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = 1722055581
   )
   @Export("varpId")
   int varpId;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = 1622531817
   )
   @Export("configId")
   int configId;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = -287686805
   )
   @Export("ambientSoundId")
   public int ambientSoundId;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = 224330621
   )
   @Export("int4")
   public int int4;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -1383293339
   )
   @Export("int5")
   public int int5;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = 1346356525
   )
   @Export("int6")
   public int int6;
   @ObfuscatedName("ab")
   public int[] field3547;
   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "Lgi;"
   )
   IterableHashTable field3537;

   static {
      ObjectDefinition_isLowDetail = false;
      objects = new NodeCache(4096);
      field3502 = new NodeCache(500);
      cachedModels = new NodeCache(30);
      field3504 = new NodeCache(30);
      field3526 = new ModelData[4];
   }

   ObjectComposition() {
      this.name = "null";
      this.sizeX = 1;
      this.sizeY = 1;
      this.interactType = 2;
      this.boolean1 = true;
      this.int1 = -1;
      this.clipType = -1;
      this.nonFlatShading = false;
      this.modelClipped = false;
      this.animationId = -1;
      this.int2 = 16;
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
      this.boolean2 = false;
      this.isSolid = false;
      this.int3 = -1;
      this.varpId = -1;
      this.configId = -1;
      this.ambientSoundId = -1;
      this.int4 = 0;
      this.int5 = 0;
      this.int6 = 0;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "866794836"
   )
   @Export("post")
   void post() {
      if(this.int1 == -1) {
         this.int1 = 0;
         if(this.objectModels != null && (this.objectTypes == null || this.objectTypes[0] == 10)) {
            this.int1 = 1;
         }

         for(int var1 = 0; var1 < 5; ++var1) {
            if(this.actions[var1] != null) {
               this.int1 = 1;
            }
         }
      }

      if(this.int3 == -1) {
         this.int3 = this.interactType != 0?1:0;
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lfr;I)V",
      garbageValue = "1224422231"
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

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Lfr;IS)V",
      garbageValue = "7701"
   )
   @Export("loadData")
   void loadData(Buffer var1, int var2) {
      int var3;
      int var4;
      if(var2 == 1) {
         var3 = var1.readUnsignedByte();
         if(var3 > 0) {
            if(this.objectModels != null && !ObjectDefinition_isLowDetail) {
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
            if(this.objectModels != null && !ObjectDefinition_isLowDetail) {
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
         this.boolean1 = false;
      } else if(var2 == 18) {
         this.boolean1 = false;
      } else if(var2 == 19) {
         this.int1 = var1.readUnsignedByte();
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
         this.int2 = var1.readUnsignedByte();
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
         this.boolean2 = true;
      } else if(var2 == 74) {
         this.isSolid = true;
      } else if(var2 == 75) {
         this.int3 = var1.readUnsignedByte();
      } else if(var2 != 77 && var2 != 92) {
         if(var2 == 78) {
            this.ambientSoundId = var1.readUnsignedShort();
            this.int4 = var1.readUnsignedByte();
         } else if(var2 == 79) {
            this.int5 = var1.readUnsignedShort();
            this.int6 = var1.readUnsignedShort();
            this.int4 = var1.readUnsignedByte();
            var3 = var1.readUnsignedByte();
            this.field3547 = new int[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field3547[var4] = var1.readUnsignedShort();
            }
         } else if(var2 == 81) {
            this.clipType = var1.readUnsignedByte() * 256;
         } else if(var2 == 82) {
            this.mapIconId = var1.readUnsignedShort();
         } else if(var2 == 249) {
            this.field3537 = CacheFile.readStringIntParameters(var1, this.field3537);
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
      garbageValue = "2109430026"
   )
   public final boolean method4694(int var1) {
      if(this.objectTypes != null) {
         for(int var4 = 0; var4 < this.objectTypes.length; ++var4) {
            if(this.objectTypes[var4] == var1) {
               return class54.field638.tryLoadRecord(this.objectModels[var4] & 65535, 0);
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
            var2 &= class54.field638.tryLoadRecord(this.objectModels[var3] & 65535, 0);
         }

         return var2;
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1091403181"
   )
   public final boolean method4729() {
      if(this.objectModels == null) {
         return true;
      } else {
         boolean var1 = true;

         for(int var2 = 0; var2 < this.objectModels.length; ++var2) {
            var1 &= class54.field638.tryLoadRecord(this.objectModels[var2] & 65535, 0);
         }

         return var1;
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(II[[IIIII)Les;",
      garbageValue = "-937937365"
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
            var10.field1736 = (short)(this.ambient + 64);
            var10.contrast = (short)(this.contrast + 768);
            var10.computeNormals();
            var9 = var10;
         }

         cachedModels.put((CacheableNode)var9, var7);
      }

      if(this.nonFlatShading) {
         var9 = ((ModelData)var9).method2526();
      }

      if(this.clipType >= 0) {
         if(var9 instanceof Model) {
            var9 = ((Model)var9).method2618(var3, var4, var5, var6, true, this.clipType);
         } else if(var9 instanceof ModelData) {
            var9 = ((ModelData)var9).method2515(var3, var4, var5, var6, true, this.clipType);
         }
      }

      return (Renderable)var9;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(II[[IIIII)Leh;",
      garbageValue = "1731010215"
   )
   public final Model method4699(int var1, int var2, int[][] var3, int var4, int var5, int var6) {
      long var7;
      if(this.objectTypes == null) {
         var7 = (long)(var2 + (this.id << 10));
      } else {
         var7 = (long)(var2 + (var1 << 3) + (this.id << 10));
      }

      Model var9 = (Model)field3504.get(var7);
      if(var9 == null) {
         ModelData var10 = this.getModel(var1, var2);
         if(var10 == null) {
            return null;
         }

         var9 = var10.light(this.ambient + 64, this.contrast + 768, -50, -10, -50);
         field3504.put(var9, var7);
      }

      if(this.clipType >= 0) {
         var9 = var9.method2618(var3, var4, var5, var6, true, this.clipType);
      }

      return var9;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II[[IIIILjj;IB)Leh;",
      garbageValue = "83"
   )
   public final Model method4746(int var1, int var2, int[][] var3, int var4, int var5, int var6, Sequence var7, int var8) {
      long var9;
      if(this.objectTypes == null) {
         var9 = (long)(var2 + (this.id << 10));
      } else {
         var9 = (long)(var2 + (var1 << 3) + (this.id << 10));
      }

      Model var11 = (Model)field3504.get(var9);
      if(var11 == null) {
         ModelData var12 = this.getModel(var1, var2);
         if(var12 == null) {
            return null;
         }

         var11 = var12.light(this.ambient + 64, this.contrast + 768, -50, -10, -50);
         field3504.put(var11, var9);
      }

      if(var7 == null && this.clipType == -1) {
         return var11;
      } else {
         if(var7 != null) {
            var11 = var7.method4883(var11, var8, var2);
         } else {
            var11 = var11.method2619(true);
         }

         if(this.clipType >= 0) {
            var11 = var11.method2618(var3, var4, var5, var6, false, this.clipType);
         }

         return var11;
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(III)Ldr;",
      garbageValue = "-1794420958"
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

            var3 = (ModelData)field3502.get((long)var7);
            if(var3 == null) {
               var3 = ModelData.method2510(class54.field638, var7 & 65535, 0);
               if(var3 == null) {
                  return null;
               }

               if(var4) {
                  var3.method2524();
               }

               field3502.put(var3, (long)var7);
            }

            if(var5 > 1) {
               field3526[var6] = var3;
            }
         }

         if(var5 > 1) {
            var3 = new ModelData(field3526, var5);
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

         var3 = (ModelData)field3502.get((long)var5);
         if(var3 == null) {
            var3 = ModelData.method2510(class54.field638, var5 & 65535, 0);
            if(var3 == null) {
               return null;
            }

            if(var10) {
               var3.method2524();
            }

            field3502.put(var3, (long)var5);
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
         var8.method2520(256);
         var8.method2521(45, 0, -45);
      }

      var2 &= 3;
      if(var2 == 1) {
         var8.method2543();
      } else if(var2 == 2) {
         var8.method2518();
      } else if(var2 == 3) {
         var8.method2561();
      }

      if(this.recolorToFind != null) {
         for(var7 = 0; var7 < this.recolorToFind.length; ++var7) {
            var8.recolor(this.recolorToFind[var7], this.recolorToReplace[var7]);
         }
      }

      if(this.textureToFind != null) {
         for(var7 = 0; var7 < this.textureToFind.length; ++var7) {
            var8.method2523(this.textureToFind[var7], this.textureToReplace[var7]);
         }
      }

      if(var4) {
         var8.method2533(this.modelSizeX, this.modelSizeHeight, this.modelSizeY);
      }

      if(var11) {
         var8.method2521(this.offsetX, this.offsetHeight, this.offsetY);
      }

      return var8;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)Ljv;",
      garbageValue = "-1633693466"
   )
   @Export("getImpostor")
   public final ObjectComposition getImpostor() {
      int var1 = -1;
      if(this.varpId != -1) {
         var1 = Friend.getVarbit(this.varpId);
      } else if(this.configId != -1) {
         var1 = class218.widgetSettings[this.configId];
      }

      int var2;
      if(var1 >= 0 && var1 < this.impostorIds.length - 1) {
         var2 = this.impostorIds[var1];
      } else {
         var2 = this.impostorIds[this.impostorIds.length - 1];
      }

      return var2 != -1?class3.getObjectDefinition(var2):null;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1252221315"
   )
   public int method4701(int var1, int var2) {
      return IndexData.method4372(this.field3537, var1, var2);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)Ljava/lang/String;",
      garbageValue = "944384674"
   )
   public String method4702(int var1, String var2) {
      return Occluder.method3016(this.field3537, var1, var2);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-440140711"
   )
   public boolean method4691() {
      if(this.impostorIds == null) {
         return this.ambientSoundId != -1 || this.field3547 != null;
      } else {
         for(int var1 = 0; var1 < this.impostorIds.length; ++var1) {
            if(this.impostorIds[var1] != -1) {
               ObjectComposition var2 = class3.getObjectDefinition(this.impostorIds[var1]);
               if(var2.ambientSoundId != -1 || var2.field3547 != null) {
                  return true;
               }
            }
         }

         return false;
      }
   }
}
