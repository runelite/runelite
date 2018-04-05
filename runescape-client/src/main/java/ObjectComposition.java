import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ja")
@Implements("ObjectComposition")
public class ObjectComposition extends CacheableNode {
   @ObfuscatedName("o")
   @Export("objectCompositionLowDetail")
   static boolean objectCompositionLowDetail;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Ljf;"
   )
   @Export("objects_ref")
   static IndexDataBase objects_ref;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Ljf;"
   )
   static IndexDataBase field3591;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lhd;"
   )
   @Export("objects")
   static NodeCache objects;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lhd;"
   )
   public static NodeCache field3593;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lhd;"
   )
   @Export("cachedModels")
   static NodeCache cachedModels;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lhd;"
   )
   static NodeCache field3595;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "[Ldg;"
   )
   static ModelData[] field3596;
   @ObfuscatedName("ge")
   @ObfuscatedGetter(
      intValue = -475017883
   )
   static int field3640;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1510932793
   )
   @Export("id")
   public int id;
   @ObfuscatedName("x")
   @Export("objectModels")
   int[] objectModels;
   @ObfuscatedName("y")
   @Export("objectTypes")
   int[] objectTypes;
   @ObfuscatedName("a")
   @Export("name")
   public String name;
   @ObfuscatedName("w")
   @Export("recolorToFind")
   short[] recolorToFind;
   @ObfuscatedName("n")
   @Export("recolorToReplace")
   short[] recolorToReplace;
   @ObfuscatedName("l")
   @Export("textureToFind")
   short[] textureToFind;
   @ObfuscatedName("s")
   @Export("textureToReplace")
   short[] textureToReplace;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1455358687
   )
   @Export("width")
   public int width;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 934690193
   )
   @Export("length")
   public int length;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -781134433
   )
   @Export("clipType")
   public int clipType;
   @ObfuscatedName("j")
   @Export("blocksProjectile")
   public boolean blocksProjectile;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1096264327
   )
   @Export("int1")
   public int int1;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1734548283
   )
   @Export("contouredGround")
   int contouredGround;
   @ObfuscatedName("f")
   @Export("nonFlatShading")
   boolean nonFlatShading;
   @ObfuscatedName("p")
   @Export("modelClipped")
   public boolean modelClipped;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 2086846389
   )
   @Export("animationId")
   public int animationId;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 27823839
   )
   @Export("decorDisplacement")
   public int decorDisplacement;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = -1664673363
   )
   @Export("ambient")
   int ambient;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = -154840679
   )
   @Export("contrast")
   int contrast;
   @ObfuscatedName("ag")
   @Export("actions")
   public String[] actions;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = 416000589
   )
   @Export("mapIconId")
   public int mapIconId;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = 2001153417
   )
   @Export("mapSceneId")
   public int mapSceneId;
   @ObfuscatedName("al")
   @Export("isRotated")
   boolean isRotated;
   @ObfuscatedName("ah")
   @Export("clipped")
   public boolean clipped;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = -327885905
   )
   @Export("modelSizeX")
   int modelSizeX;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = 747578787
   )
   @Export("modelSizeHeight")
   int modelSizeHeight;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = 1509908869
   )
   @Export("modelSizeY")
   int modelSizeY;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = 1193964905
   )
   @Export("offsetX")
   int offsetX;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = 1067061717
   )
   @Export("offsetHeight")
   int offsetHeight;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = -898084177
   )
   @Export("offsetY")
   int offsetY;
   @ObfuscatedName("am")
   @Export("obstructsGround")
   public boolean obstructsGround;
   @ObfuscatedName("ao")
   @Export("isHollow")
   boolean isHollow;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -867520011
   )
   @Export("supportItems")
   public int supportItems;
   @ObfuscatedName("ad")
   @Export("impostorIds")
   public int[] impostorIds;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = -205761117
   )
   @Export("varpId")
   int varpId;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = -1273160487
   )
   @Export("configId")
   int configId;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = -749402505
   )
   @Export("ambientSoundId")
   public int ambientSoundId;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = -1148374753
   )
   @Export("int4")
   public int int4;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = 2072903957
   )
   @Export("int5")
   public int int5;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = 336951045
   )
   @Export("int6")
   public int int6;
   @ObfuscatedName("as")
   public int[] field3614;
   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "Lha;"
   )
   @Export("params")
   IterableHashTable params;

   static {
      objectCompositionLowDetail = false;
      objects = new NodeCache(4096);
      field3593 = new NodeCache(500);
      cachedModels = new NodeCache(30);
      field3595 = new NodeCache(30);
      field3596 = new ModelData[4];
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

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "251492888"
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

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lgc;I)V",
      garbageValue = "1273085813"
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

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lgc;IB)V",
      garbageValue = "64"
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
            this.field3614 = new int[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field3614[var4] = var1.readUnsignedShort();
            }
         } else if(var2 == 81) {
            this.contouredGround = var1.readUnsignedByte() * 256;
         } else if(var2 == 82) {
            this.mapIconId = var1.readUnsignedShort();
         } else if(var2 == 249) {
            this.params = class28.readStringIntParameters(var1, this.params);
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

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-2035740250"
   )
   public final boolean method4996(int var1) {
      if(this.objectTypes != null) {
         for(int var4 = 0; var4 < this.objectTypes.length; ++var4) {
            if(this.objectTypes[var4] == var1) {
               return field3591.tryLoadRecord(this.objectModels[var4] & 65535, 0);
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
            var2 &= field3591.tryLoadRecord(this.objectModels[var3] & 65535, 0);
         }

         return var2;
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1198735405"
   )
   public final boolean method5027() {
      if(this.objectModels == null) {
         return true;
      } else {
         boolean var1 = true;

         for(int var2 = 0; var2 < this.objectModels.length; ++var2) {
            var1 &= field3591.tryLoadRecord(this.objectModels[var2] & 65535, 0);
         }

         return var1;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II[[IIIIB)Led;",
      garbageValue = "-29"
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
            var10.field1731 = (short)(this.ambient + 64);
            var10.contrast = (short)(this.contrast + 768);
            var10.computeNormals();
            var9 = var10;
         }

         cachedModels.put((CacheableNode)var9, var7);
      }

      if(this.nonFlatShading) {
         var9 = ((ModelData)var9).method2604();
      }

      if(this.contouredGround >= 0) {
         if(var9 instanceof Model) {
            var9 = ((Model)var9).method2686(var3, var4, var5, var6, true, this.contouredGround);
         } else if(var9 instanceof ModelData) {
            var9 = ((ModelData)var9).method2601(var3, var4, var5, var6, true, this.contouredGround);
         }
      }

      return (Renderable)var9;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(II[[IIIII)Lei;",
      garbageValue = "-1396329037"
   )
   public final Model method4999(int var1, int var2, int[][] var3, int var4, int var5, int var6) {
      long var7;
      if(this.objectTypes == null) {
         var7 = (long)(var2 + (this.id << 10));
      } else {
         var7 = (long)(var2 + (var1 << 3) + (this.id << 10));
      }

      Model var9 = (Model)field3595.get(var7);
      if(var9 == null) {
         ModelData var10 = this.getModel(var1, var2);
         if(var10 == null) {
            return null;
         }

         var9 = var10.light(this.ambient + 64, this.contrast + 768, -50, -10, -50);
         field3595.put(var9, var7);
      }

      if(this.contouredGround >= 0) {
         var9 = var9.method2686(var3, var4, var5, var6, true, this.contouredGround);
      }

      return var9;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II[[IIIILke;IB)Lei;",
      garbageValue = "14"
   )
   public final Model method5000(int var1, int var2, int[][] var3, int var4, int var5, int var6, Sequence var7, int var8) {
      long var9;
      if(this.objectTypes == null) {
         var9 = (long)(var2 + (this.id << 10));
      } else {
         var9 = (long)(var2 + (var1 << 3) + (this.id << 10));
      }

      Model var11 = (Model)field3595.get(var9);
      if(var11 == null) {
         ModelData var12 = this.getModel(var1, var2);
         if(var12 == null) {
            return null;
         }

         var11 = var12.light(this.ambient + 64, this.contrast + 768, -50, -10, -50);
         field3595.put(var11, var9);
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
            var11 = var11.method2686(var3, var4, var5, var6, false, this.contouredGround);
         }

         return var11;
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IIB)Ldg;",
      garbageValue = "101"
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

            var3 = (ModelData)field3593.get((long)var7);
            if(var3 == null) {
               var3 = ModelData.method2645(field3591, var7 & 65535, 0);
               if(var3 == null) {
                  return null;
               }

               if(var4) {
                  var3.method2614();
               }

               field3593.put(var3, (long)var7);
            }

            if(var5 > 1) {
               field3596[var6] = var3;
            }
         }

         if(var5 > 1) {
            var3 = new ModelData(field3596, var5);
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

         var3 = (ModelData)field3593.get((long)var5);
         if(var3 == null) {
            var3 = ModelData.method2645(field3591, var5 & 65535, 0);
            if(var3 == null) {
               return null;
            }

            if(var10) {
               var3.method2614();
            }

            field3593.put(var3, (long)var5);
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
         var8.method2606(256);
         var8.method2611(45, 0, -45);
      }

      var2 &= 3;
      if(var2 == 1) {
         var8.method2607();
      } else if(var2 == 2) {
         var8.method2625();
      } else if(var2 == 3) {
         var8.method2610();
      }

      if(this.recolorToFind != null) {
         for(var7 = 0; var7 < this.recolorToFind.length; ++var7) {
            var8.recolor(this.recolorToFind[var7], this.recolorToReplace[var7]);
         }
      }

      if(this.textureToFind != null) {
         for(var7 = 0; var7 < this.textureToFind.length; ++var7) {
            var8.method2613(this.textureToFind[var7], this.textureToReplace[var7]);
         }
      }

      if(var4) {
         var8.method2615(this.modelSizeX, this.modelSizeHeight, this.modelSizeY);
      }

      if(var11) {
         var8.method2611(this.offsetX, this.offsetHeight, this.offsetY);
      }

      return var8;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)Lja;",
      garbageValue = "1692414115"
   )
   @Export("getImpostor")
   public final ObjectComposition getImpostor() {
      int var1 = -1;
      if(this.varpId != -1) {
         var1 = DynamicObject.getVarbit(this.varpId);
      } else if(this.configId != -1) {
         var1 = class237.clientVarps[this.configId];
      }

      int var2;
      if(var1 >= 0 && var1 < this.impostorIds.length - 1) {
         var2 = this.impostorIds[var1];
      } else {
         var2 = this.impostorIds[this.impostorIds.length - 1];
      }

      return var2 != -1?GameCanvas.getObjectDefinition(var2):null;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "0"
   )
   public int method5003(int var1, int var2) {
      return Frames.method3062(this.params, var1, var2);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)Ljava/lang/String;",
      garbageValue = "2100256837"
   )
   public String method5008(int var1, String var2) {
      return WorldMapType1.method309(this.params, var1, var2);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "848512884"
   )
   public boolean method5005() {
      if(this.impostorIds == null) {
         return this.ambientSoundId != -1 || this.field3614 != null;
      } else {
         for(int var1 = 0; var1 < this.impostorIds.length; ++var1) {
            if(this.impostorIds[var1] != -1) {
               ObjectComposition var2 = GameCanvas.getObjectDefinition(this.impostorIds[var1]);
               if(var2.ambientSoundId != -1 || var2.field3614 != null) {
                  return true;
               }
            }
         }

         return false;
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Ljf;Ljf;I)V",
      garbageValue = "-1011356566"
   )
   public static void method5053(IndexDataBase var0, IndexDataBase var1) {
      CombatInfo2.field3532 = var0;
      CombatInfo2.field3528 = var1;
   }

   @ObfuscatedName("fd")
   @ObfuscatedSignature(
      signature = "(Lba;S)V",
      garbageValue = "12643"
   )
   static final void method5018(Actor var0) {
      if(var0.field1204 == Client.gameCycle || var0.animation == -1 || var0.actionAnimationDisable != 0 || var0.actionFrameCycle + 1 > CombatInfo1.getAnimation(var0.animation).frameLengths[var0.actionFrame]) {
         int var1 = var0.field1204 - var0.field1166;
         int var2 = Client.gameCycle - var0.field1166;
         int var3 = var0.field1203 * 128 + var0.field1172 * 64;
         int var4 = var0.field1199 * 128 + var0.field1172 * 64;
         int var5 = var0.field1200 * 128 + var0.field1172 * 64;
         int var6 = var0.field1202 * 128 + var0.field1172 * 64;
         var0.x = (var5 * var2 + var3 * (var1 - var2)) / var1;
         var0.y = (var6 * var2 + var4 * (var1 - var2)) / var1;
      }

      var0.field1158 = 0;
      var0.orientation = var0.field1171;
      var0.angle = var0.orientation;
   }
}
