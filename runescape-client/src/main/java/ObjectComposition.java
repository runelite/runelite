import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jp")
@Implements("ObjectComposition")
public class ObjectComposition extends CacheableNode {
   @ObfuscatedName("w")
   @Export("objectCompositionLowDetail")
   static boolean objectCompositionLowDetail;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Liv;"
   )
   @Export("objects_ref")
   static IndexDataBase objects_ref;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lgj;"
   )
   @Export("objects")
   public static NodeCache objects;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lgj;"
   )
   public static NodeCache field3426;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lgj;"
   )
   @Export("cachedModels")
   public static NodeCache cachedModels;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lgj;"
   )
   public static NodeCache field3394;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "[Ldo;"
   )
   static ModelData[] field3419;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -133963783
   )
   @Export("id")
   public int id;
   @ObfuscatedName("a")
   @Export("objectModels")
   int[] objectModels;
   @ObfuscatedName("l")
   @Export("objectTypes")
   int[] objectTypes;
   @ObfuscatedName("d")
   @Export("name")
   public String name;
   @ObfuscatedName("s")
   @Export("recolorToFind")
   short[] recolorToFind;
   @ObfuscatedName("p")
   @Export("recolorToReplace")
   short[] recolorToReplace;
   @ObfuscatedName("g")
   @Export("textureToFind")
   short[] textureToFind;
   @ObfuscatedName("y")
   @Export("textureToReplace")
   short[] textureToReplace;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1213940891
   )
   @Export("width")
   public int width;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 424814631
   )
   @Export("length")
   public int length;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 282185155
   )
   @Export("clipType")
   public int clipType;
   @ObfuscatedName("u")
   @Export("blocksProjectile")
   public boolean blocksProjectile;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1947548295
   )
   @Export("int1")
   public int int1;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 181240873
   )
   @Export("contouredGround")
   int contouredGround;
   @ObfuscatedName("k")
   @Export("nonFlatShading")
   boolean nonFlatShading;
   @ObfuscatedName("r")
   @Export("modelClipped")
   public boolean modelClipped;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -729681769
   )
   @Export("animationId")
   public int animationId;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 2068057911
   )
   @Export("decorDisplacement")
   public int decorDisplacement;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = -1788738971
   )
   @Export("ambient")
   int ambient;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = 1269154545
   )
   @Export("contrast")
   int contrast;
   @ObfuscatedName("ad")
   @Export("actions")
   public String[] actions;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = 1646373357
   )
   @Export("mapIconId")
   public int mapIconId;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = 1497618141
   )
   @Export("mapSceneId")
   public int mapSceneId;
   @ObfuscatedName("an")
   @Export("isRotated")
   boolean isRotated;
   @ObfuscatedName("as")
   @Export("clipped")
   public boolean clipped;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = 1866455377
   )
   @Export("modelSizeX")
   int modelSizeX;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = 973304381
   )
   @Export("modelSizeHeight")
   int modelSizeHeight;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = -1872279465
   )
   @Export("modelSizeY")
   int modelSizeY;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = -1452073219
   )
   @Export("offsetX")
   int offsetX;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = 1997048097
   )
   @Export("offsetHeight")
   int offsetHeight;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = -145346111
   )
   @Export("offsetY")
   int offsetY;
   @ObfuscatedName("af")
   @Export("obstructsGround")
   public boolean obstructsGround;
   @ObfuscatedName("am")
   @Export("isHollow")
   boolean isHollow;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = -327548675
   )
   @Export("supportItems")
   public int supportItems;
   @ObfuscatedName("aj")
   @Export("impostorIds")
   public int[] impostorIds;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 1395323443
   )
   @Export("varpId")
   int varpId;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = 1277891373
   )
   @Export("configId")
   int configId;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = 101670429
   )
   @Export("ambientSoundId")
   public int ambientSoundId;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = -957635567
   )
   @Export("int4")
   public int int4;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = 1115696985
   )
   @Export("int5")
   public int int5;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = 1823284113
   )
   @Export("int6")
   public int int6;
   @ObfuscatedName("ax")
   public int[] field3437;
   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "Lgx;"
   )
   @Export("params")
   IterableHashTable params;

   static {
      objectCompositionLowDetail = false;
      objects = new NodeCache(4096);
      field3426 = new NodeCache(500);
      cachedModels = new NodeCache(30);
      field3394 = new NodeCache(30);
      field3419 = new ModelData[4];
   }

   ObjectComposition() {
      this.name = "null";
      this.width = 1;
      this.length = 1;
      this.clipType = 2;
      this.blocksProjectile = true;
      this.int1 = -1;
      this.contouredGround = -1;
      this.nonFlatShading = false;
      this.modelClipped = false;
      this.animationId = -1;
      this.decorDisplacement = 16;
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
      this.obstructsGround = false;
      this.isHollow = false;
      this.supportItems = -1;
      this.varpId = -1;
      this.configId = -1;
      this.ambientSoundId = -1;
      this.int4 = 0;
      this.int5 = 0;
      this.int6 = 0;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "22339"
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

      if(this.supportItems == -1) {
         this.supportItems = this.clipType != 0?1:0;
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lgy;I)V",
      garbageValue = "-653455968"
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
      signature = "(Lgy;II)V",
      garbageValue = "-407614845"
   )
   @Export("loadData")
   void loadData(Buffer var1, int var2) {
      int var3;
      int var4;
      if(var2 == 1) {
         var3 = var1.readUnsignedByte();
         if(var3 > 0) {
            if(this.objectModels != null && !objectCompositionLowDetail) {
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
            if(this.objectModels != null && !objectCompositionLowDetail) {
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
         this.width = var1.readUnsignedByte();
      } else if(var2 == 15) {
         this.length = var1.readUnsignedByte();
      } else if(var2 == 17) {
         this.clipType = 0;
         this.blocksProjectile = false;
      } else if(var2 == 18) {
         this.blocksProjectile = false;
      } else if(var2 == 19) {
         this.int1 = var1.readUnsignedByte();
      } else if(var2 == 21) {
         this.contouredGround = 0;
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
         this.clipType = 1;
      } else if(var2 == 28) {
         this.decorDisplacement = var1.readUnsignedByte();
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
         this.obstructsGround = true;
      } else if(var2 == 74) {
         this.isHollow = true;
      } else if(var2 == 75) {
         this.supportItems = var1.readUnsignedByte();
      } else if(var2 != 77 && var2 != 92) {
         if(var2 == 78) {
            this.ambientSoundId = var1.readUnsignedShort();
            this.int4 = var1.readUnsignedByte();
         } else if(var2 == 79) {
            this.int5 = var1.readUnsignedShort();
            this.int6 = var1.readUnsignedShort();
            this.int4 = var1.readUnsignedByte();
            var3 = var1.readUnsignedByte();
            this.field3437 = new int[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field3437[var4] = var1.readUnsignedShort();
            }
         } else if(var2 == 81) {
            this.contouredGround = var1.readUnsignedByte() * 256;
         } else if(var2 == 82) {
            this.mapIconId = var1.readUnsignedShort();
         } else if(var2 == 249) {
            this.params = CacheFile.readStringIntParameters(var1, this.params);
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

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "40"
   )
   public final boolean method5049(int var1) {
      if(this.objectTypes != null) {
         for(int var4 = 0; var4 < this.objectTypes.length; ++var4) {
            if(this.objectTypes[var4] == var1) {
               return class9.field63.tryLoadRecord(this.objectModels[var4] & 65535, 0);
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
            var2 &= class9.field63.tryLoadRecord(this.objectModels[var3] & 65535, 0);
         }

         return var2;
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1487214675"
   )
   public final boolean method5046() {
      if(this.objectModels == null) {
         return true;
      } else {
         boolean var1 = true;

         for(int var2 = 0; var2 < this.objectModels.length; ++var2) {
            var1 &= class9.field63.tryLoadRecord(this.objectModels[var2] & 65535, 0);
         }

         return var1;
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II[[IIIIB)Ldz;",
      garbageValue = "8"
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
            var10.field1515 = (short)(this.ambient + 64);
            var10.contrast = (short)(this.contrast + 768);
            var10.computeNormals();
            var9 = var10;
         }

         cachedModels.put((CacheableNode)var9, var7);
      }

      if(this.nonFlatShading) {
         var9 = ((ModelData)var9).method2624();
      }

      if(this.contouredGround >= 0) {
         if(var9 instanceof Model) {
            var9 = ((Model)var9).method2720(var3, var4, var5, var6, true, this.contouredGround);
         } else if(var9 instanceof ModelData) {
            var9 = ((ModelData)var9).method2625(var3, var4, var5, var6, true, this.contouredGround);
         }
      }

      return (Renderable)var9;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II[[IIIII)Ldk;",
      garbageValue = "1233306477"
   )
   public final Model method5052(int var1, int var2, int[][] var3, int var4, int var5, int var6) {
      long var7;
      if(this.objectTypes == null) {
         var7 = (long)(var2 + (this.id << 10));
      } else {
         var7 = (long)(var2 + (var1 << 3) + (this.id << 10));
      }

      Model var9 = (Model)field3394.get(var7);
      if(var9 == null) {
         ModelData var10 = this.getModel(var1, var2);
         if(var10 == null) {
            return null;
         }

         var9 = var10.light(this.ambient + 64, this.contrast + 768, -50, -10, -50);
         field3394.put(var9, var7);
      }

      if(this.contouredGround >= 0) {
         var9 = var9.method2720(var3, var4, var5, var6, true, this.contouredGround);
      }

      return var9;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II[[IIIILjh;II)Ldk;",
      garbageValue = "664114017"
   )
   public final Model method5092(int var1, int var2, int[][] var3, int var4, int var5, int var6, Sequence var7, int var8) {
      long var9;
      if(this.objectTypes == null) {
         var9 = (long)(var2 + (this.id << 10));
      } else {
         var9 = (long)(var2 + (var1 << 3) + (this.id << 10));
      }

      Model var11 = (Model)field3394.get(var9);
      if(var11 == null) {
         ModelData var12 = this.getModel(var1, var2);
         if(var12 == null) {
            return null;
         }

         var11 = var12.light(this.ambient + 64, this.contrast + 768, -50, -10, -50);
         field3394.put(var11, var9);
      }

      if(var7 == null && this.contouredGround == -1) {
         return var11;
      } else {
         if(var7 != null) {
            var11 = var7.transformObjectModel(var11, var8, var2);
         } else {
            var11 = var11.toSharedModel(true);
         }

         if(this.contouredGround >= 0) {
            var11 = var11.method2720(var3, var4, var5, var6, false, this.contouredGround);
         }

         return var11;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(III)Ldo;",
      garbageValue = "1463143272"
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

            var3 = (ModelData)field3426.get((long)var7);
            if(var3 == null) {
               var3 = ModelData.method2619(class9.field63, var7 & 65535, 0);
               if(var3 == null) {
                  return null;
               }

               if(var4) {
                  var3.method2633();
               }

               field3426.put(var3, (long)var7);
            }

            if(var5 > 1) {
               field3419[var6] = var3;
            }
         }

         if(var5 > 1) {
            var3 = new ModelData(field3419, var5);
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

         var3 = (ModelData)field3426.get((long)var5);
         if(var3 == null) {
            var3 = ModelData.method2619(class9.field63, var5 & 65535, 0);
            if(var3 == null) {
               return null;
            }

            if(var10) {
               var3.method2633();
            }

            field3426.put(var3, (long)var5);
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

      ModelData var8 = new ModelData(var3, var2 == 0 && !var4 && !var11, this.recolorToFind == null, this.textureToFind == null, true);
      if(var1 == 4 && var2 > 3) {
         var8.method2663(256);
         var8.method2630(45, 0, -45);
      }

      var2 &= 3;
      if(var2 == 1) {
         var8.method2649();
      } else if(var2 == 2) {
         var8.method2627();
      } else if(var2 == 3) {
         var8.method2641();
      }

      if(this.recolorToFind != null) {
         for(var7 = 0; var7 < this.recolorToFind.length; ++var7) {
            var8.recolor(this.recolorToFind[var7], this.recolorToReplace[var7]);
         }
      }

      if(this.textureToFind != null) {
         for(var7 = 0; var7 < this.textureToFind.length; ++var7) {
            var8.method2632(this.textureToFind[var7], this.textureToReplace[var7]);
         }
      }

      if(var4) {
         var8.method2674(this.modelSizeX, this.modelSizeHeight, this.modelSizeY);
      }

      if(var11) {
         var8.method2630(this.offsetX, this.offsetHeight, this.offsetY);
      }

      return var8;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)Ljp;",
      garbageValue = "1078675837"
   )
   @Export("getImpostor")
   public final ObjectComposition getImpostor() {
      int var1 = -1;
      if(this.varpId != -1) {
         var1 = class138.getVarbit(this.varpId);
      } else if(this.configId != -1) {
         var1 = class225.clientVarps[this.configId];
      }

      int var2;
      if(var1 >= 0 && var1 < this.impostorIds.length - 1) {
         var2 = this.impostorIds[var1];
      } else {
         var2 = this.impostorIds[this.impostorIds.length - 1];
      }

      return var2 != -1?SoundTaskDataProvider.getObjectDefinition(var2):null;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-312914148"
   )
   public int method5078(int var1, int var2) {
      IterableHashTable var4 = this.params;
      int var3;
      if(var4 == null) {
         var3 = var2;
      } else {
         IntegerNode var5 = (IntegerNode)var4.get((long)var1);
         if(var5 == null) {
            var3 = var2;
         } else {
            var3 = var5.value;
         }
      }

      return var3;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;S)Ljava/lang/String;",
      garbageValue = "255"
   )
   public String method5057(int var1, String var2) {
      return CombatInfoListHolder.method1822(this.params, var1, var2);
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "1"
   )
   public boolean method5062() {
      if(this.impostorIds == null) {
         return this.ambientSoundId != -1 || this.field3437 != null;
      } else {
         for(int var1 = 0; var1 < this.impostorIds.length; ++var1) {
            if(this.impostorIds[var1] != -1) {
               ObjectComposition var2 = SoundTaskDataProvider.getObjectDefinition(this.impostorIds[var1]);
               if(var2.ambientSoundId != -1 || var2.field3437 != null) {
                  return true;
               }
            }
         }

         return false;
      }
   }
}
