import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("js")
@Implements("ObjectComposition")
public class ObjectComposition extends CacheableNode {
   @ObfuscatedName("g")
   @Export("objectCompositionLowDetail")
   public static boolean objectCompositionLowDetail;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Ljr;"
   )
   @Export("objects_ref")
   public static IndexDataBase objects_ref;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Ljr;"
   )
   public static IndexDataBase field3592;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lhi;"
   )
   @Export("objects")
   static NodeCache objects;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lhi;"
   )
   public static NodeCache field3594;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Lhi;"
   )
   @Export("cachedModels")
   static NodeCache cachedModels;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lhi;"
   )
   static NodeCache field3596;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "[Ldi;"
   )
   static ModelData[] field3636;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -729160133
   )
   @Export("id")
   public int id;
   @ObfuscatedName("h")
   @Export("objectModels")
   int[] objectModels;
   @ObfuscatedName("i")
   @Export("objectTypes")
   int[] objectTypes;
   @ObfuscatedName("o")
   @Export("name")
   public String name;
   @ObfuscatedName("d")
   @Export("recolorToFind")
   short[] recolorToFind;
   @ObfuscatedName("r")
   @Export("recolorToReplace")
   short[] recolorToReplace;
   @ObfuscatedName("p")
   @Export("textureToFind")
   short[] textureToFind;
   @ObfuscatedName("q")
   @Export("textureToReplace")
   short[] textureToReplace;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 409658451
   )
   @Export("width")
   public int width;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -641817545
   )
   @Export("length")
   public int length;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 343624513
   )
   @Export("clipType")
   public int clipType;
   @ObfuscatedName("u")
   @Export("blocksProjectile")
   public boolean blocksProjectile;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 2076126051
   )
   @Export("int1")
   public int int1;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1673941967
   )
   @Export("contouredGround")
   int contouredGround;
   @ObfuscatedName("m")
   @Export("nonFlatShading")
   boolean nonFlatShading;
   @ObfuscatedName("a")
   @Export("modelClipped")
   public boolean modelClipped;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 396529455
   )
   @Export("animationId")
   public int animationId;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1284260601
   )
   @Export("decorDisplacement")
   public int decorDisplacement;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = 808779833
   )
   @Export("ambient")
   int ambient;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = -1431829551
   )
   @Export("contrast")
   int contrast;
   @ObfuscatedName("aj")
   @Export("actions")
   public String[] actions;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = -1849427649
   )
   @Export("mapIconId")
   public int mapIconId;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = -1700985663
   )
   @Export("mapSceneId")
   public int mapSceneId;
   @ObfuscatedName("ay")
   @Export("isRotated")
   boolean isRotated;
   @ObfuscatedName("as")
   @Export("clipped")
   public boolean clipped;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = -94431207
   )
   @Export("modelSizeX")
   int modelSizeX;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -1138163661
   )
   @Export("modelSizeHeight")
   int modelSizeHeight;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = -390770819
   )
   @Export("modelSizeY")
   int modelSizeY;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = 1640498509
   )
   @Export("offsetX")
   int offsetX;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = -1851220359
   )
   @Export("offsetHeight")
   int offsetHeight;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = -1069054367
   )
   @Export("offsetY")
   int offsetY;
   @ObfuscatedName("ab")
   @Export("obstructsGround")
   public boolean obstructsGround;
   @ObfuscatedName("al")
   @Export("isHollow")
   boolean isHollow;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = -945135131
   )
   @Export("supportItems")
   public int supportItems;
   @ObfuscatedName("ah")
   @Export("impostorIds")
   public int[] impostorIds;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = -1700694405
   )
   @Export("varpId")
   int varpId;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = 1980586243
   )
   @Export("configId")
   int configId;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = 1761807345
   )
   @Export("ambientSoundId")
   public int ambientSoundId;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = -1313394897
   )
   @Export("int4")
   public int int4;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = -622962509
   )
   @Export("int5")
   public int int5;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 774554013
   )
   @Export("int6")
   public int int6;
   @ObfuscatedName("aw")
   public int[] field3639;
   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "Lhh;"
   )
   @Export("params")
   IterableHashTable params;

   static {
      objectCompositionLowDetail = false;
      objects = new NodeCache(4096);
      field3594 = new NodeCache(500);
      cachedModels = new NodeCache(30);
      field3596 = new NodeCache(30);
      field3636 = new ModelData[4];
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

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "907957323"
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

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lgg;I)V",
      garbageValue = "2039442979"
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
      signature = "(Lgg;IB)V",
      garbageValue = "63"
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
            this.field3639 = new int[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field3639[var4] = var1.readUnsignedShort();
            }
         } else if(var2 == 81) {
            this.contouredGround = var1.readUnsignedByte() * 256;
         } else if(var2 == 82) {
            this.mapIconId = var1.readUnsignedShort();
         } else if(var2 == 249) {
            this.params = class160.readStringIntParameters(var1, this.params);
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

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "297685936"
   )
   public final boolean method5080(int var1) {
      if(this.objectTypes != null) {
         for(int var4 = 0; var4 < this.objectTypes.length; ++var4) {
            if(this.objectTypes[var4] == var1) {
               return field3592.tryLoadRecord(this.objectModels[var4] & 65535, 0);
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
            var2 &= field3592.tryLoadRecord(this.objectModels[var3] & 65535, 0);
         }

         return var2;
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1973117379"
   )
   public final boolean method5085() {
      if(this.objectModels == null) {
         return true;
      } else {
         boolean var1 = true;

         for(int var2 = 0; var2 < this.objectModels.length; ++var2) {
            var1 &= field3592.tryLoadRecord(this.objectModels[var2] & 65535, 0);
         }

         return var1;
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II[[IIIII)Ley;",
      garbageValue = "-16711936"
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
            var10.field1729 = (short)(this.ambient + 64);
            var10.contrast = (short)(this.contrast * 25 + 768);
            var10.computeNormals();
            var9 = var10;
         }

         cachedModels.put((CacheableNode)var9, var7);
      }

      if(this.nonFlatShading) {
         var9 = ((ModelData)var9).method2695();
      }

      if(this.contouredGround >= 0) {
         if(var9 instanceof Model) {
            var9 = ((Model)var9).method2782(var3, var4, var5, var6, true, this.contouredGround);
         } else if(var9 instanceof ModelData) {
            var9 = ((ModelData)var9).method2696(var3, var4, var5, var6, true, this.contouredGround);
         }
      }

      return (Renderable)var9;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(II[[IIIIB)Lee;",
      garbageValue = "-11"
   )
   public final Model method5083(int var1, int var2, int[][] var3, int var4, int var5, int var6) {
      long var7;
      if(this.objectTypes == null) {
         var7 = (long)(var2 + (this.id << 10));
      } else {
         var7 = (long)(var2 + (var1 << 3) + (this.id << 10));
      }

      Model var9 = (Model)field3596.get(var7);
      if(var9 == null) {
         ModelData var10 = this.getModel(var1, var2);
         if(var10 == null) {
            return null;
         }

         var9 = var10.light(this.ambient + 64, this.contrast * 25 + 768, -50, -10, -50);
         field3596.put(var9, var7);
      }

      if(this.contouredGround >= 0) {
         var9 = var9.method2782(var3, var4, var5, var6, true, this.contouredGround);
      }

      return var9;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II[[IIIILkc;IS)Lee;",
      garbageValue = "128"
   )
   public final Model method5086(int var1, int var2, int[][] var3, int var4, int var5, int var6, Sequence var7, int var8) {
      long var9;
      if(this.objectTypes == null) {
         var9 = (long)(var2 + (this.id << 10));
      } else {
         var9 = (long)(var2 + (var1 << 3) + (this.id << 10));
      }

      Model var11 = (Model)field3596.get(var9);
      if(var11 == null) {
         ModelData var12 = this.getModel(var1, var2);
         if(var12 == null) {
            return null;
         }

         var11 = var12.light(this.ambient + 64, this.contrast * 25 + 768, -50, -10, -50);
         field3596.put(var11, var9);
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
            var11 = var11.method2782(var3, var4, var5, var6, false, this.contouredGround);
         }

         return var11;
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIB)Ldi;",
      garbageValue = "-57"
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

            var3 = (ModelData)field3594.get((long)var7);
            if(var3 == null) {
               var3 = ModelData.method2691(field3592, var7 & 65535, 0);
               if(var3 == null) {
                  return null;
               }

               if(var4) {
                  var3.method2732();
               }

               field3594.put(var3, (long)var7);
            }

            if(var5 > 1) {
               field3636[var6] = var3;
            }
         }

         if(var5 > 1) {
            var3 = new ModelData(field3636, var5);
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

         var3 = (ModelData)field3594.get((long)var5);
         if(var3 == null) {
            var3 = ModelData.method2691(field3592, var5 & 65535, 0);
            if(var3 == null) {
               return null;
            }

            if(var10) {
               var3.method2732();
            }

            field3594.put(var3, (long)var5);
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

      ModelData var8 = new ModelData(var3, var2 == 0 && !var4 && !var11, null == this.recolorToFind, this.textureToFind == null, true);
      if(var1 == 4 && var2 > 3) {
         var8.method2701(256);
         var8.method2698(45, 0, -45);
      }

      var2 &= 3;
      if(var2 == 1) {
         var8.method2731();
      } else if(var2 == 2) {
         var8.method2699();
      } else if(var2 == 3) {
         var8.method2700();
      }

      if(this.recolorToFind != null) {
         for(var7 = 0; var7 < this.recolorToFind.length; ++var7) {
            var8.recolor(this.recolorToFind[var7], this.recolorToReplace[var7]);
         }
      }

      if(this.textureToFind != null) {
         for(var7 = 0; var7 < this.textureToFind.length; ++var7) {
            var8.method2704(this.textureToFind[var7], this.textureToReplace[var7]);
         }
      }

      if(var4) {
         var8.method2706(this.modelSizeX, this.modelSizeHeight, this.modelSizeY);
      }

      if(var11) {
         var8.method2698(this.offsetX, this.offsetHeight, this.offsetY);
      }

      return var8;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)Ljs;",
      garbageValue = "2040085160"
   )
   @Export("getImpostor")
   public final ObjectComposition getImpostor() {
      int var1 = -1;
      if(this.varpId != -1) {
         var1 = VarCString.getVarbit(this.varpId);
      } else if(this.configId != -1) {
         var1 = class237.clientVarps[this.configId];
      }

      int var2;
      if(var1 >= 0 && var1 < this.impostorIds.length - 1) {
         var2 = this.impostorIds[var1];
      } else {
         var2 = this.impostorIds[this.impostorIds.length - 1];
      }

      return var2 != -1?class80.getObjectDefinition(var2):null;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1940701732"
   )
   public int method5090(int var1, int var2) {
      return NetWriter.method2162(this.params, var1, var2);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)Ljava/lang/String;",
      garbageValue = "-2067575303"
   )
   public String method5091(int var1, String var2) {
      return class169.method3365(this.params, var1, var2);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "736299664"
   )
   public boolean method5104() {
      if(this.impostorIds == null) {
         return this.ambientSoundId != -1 || this.field3639 != null;
      } else {
         for(int var1 = 0; var1 < this.impostorIds.length; ++var1) {
            if(this.impostorIds[var1] != -1) {
               ObjectComposition var2 = class80.getObjectDefinition(this.impostorIds[var1]);
               if(var2.ambientSoundId != -1 || var2.field3639 != null) {
                  return true;
               }
            }
         }

         return false;
      }
   }
}
