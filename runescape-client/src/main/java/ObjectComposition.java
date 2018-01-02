import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jf")
@Implements("ObjectComposition")
public class ObjectComposition extends CacheableNode {
   @ObfuscatedName("a")
   @Export("ObjectDefinition_isLowDetail")
   static boolean ObjectDefinition_isLowDetail;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lib;"
   )
   @Export("objects_ref")
   static IndexDataBase objects_ref;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lib;"
   )
   static IndexDataBase field3551;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lgu;"
   )
   @Export("objects")
   static NodeCache objects;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lgu;"
   )
   public static NodeCache field3512;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lgu;"
   )
   @Export("cachedModels")
   static NodeCache cachedModels;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lgu;"
   )
   static NodeCache field3521;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "[Ldm;"
   )
   static ModelData[] field3508;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1714760777
   )
   @Export("id")
   public int id;
   @ObfuscatedName("j")
   @Export("objectModels")
   int[] objectModels;
   @ObfuscatedName("x")
   @Export("objectTypes")
   int[] objectTypes;
   @ObfuscatedName("c")
   @Export("name")
   public String name;
   @ObfuscatedName("s")
   @Export("recolorToFind")
   short[] recolorToFind;
   @ObfuscatedName("n")
   @Export("recolorToReplace")
   short[] recolorToReplace;
   @ObfuscatedName("y")
   @Export("textureToFind")
   short[] textureToFind;
   @ObfuscatedName("o")
   @Export("textureToReplace")
   short[] textureToReplace;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1899287589
   )
   @Export("sizeX")
   public int sizeX;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -2057232489
   )
   @Export("sizeY")
   public int sizeY;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1161808807
   )
   @Export("interactType")
   public int interactType;
   @ObfuscatedName("m")
   @Export("boolean1")
   public boolean boolean1;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1320550455
   )
   @Export("int1")
   public int int1;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 542423197
   )
   @Export("clipType")
   int clipType;
   @ObfuscatedName("h")
   @Export("nonFlatShading")
   boolean nonFlatShading;
   @ObfuscatedName("d")
   @Export("modelClipped")
   public boolean modelClipped;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -334665683
   )
   @Export("animationId")
   public int animationId;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1284309911
   )
   @Export("int2")
   public int int2;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = 2045893851
   )
   @Export("ambient")
   int ambient;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = 931874435
   )
   @Export("contrast")
   int contrast;
   @ObfuscatedName("ag")
   @Export("actions")
   public String[] actions;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = -956559097
   )
   @Export("mapIconId")
   public int mapIconId;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = -1042448959
   )
   @Export("mapSceneId")
   public int mapSceneId;
   @ObfuscatedName("aq")
   @Export("isRotated")
   boolean isRotated;
   @ObfuscatedName("ax")
   @Export("clipped")
   public boolean clipped;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = 1342124689
   )
   @Export("modelSizeX")
   int modelSizeX;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = -1468073391
   )
   @Export("modelSizeHeight")
   int modelSizeHeight;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = -1186652121
   )
   @Export("modelSizeY")
   int modelSizeY;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = 1247660289
   )
   @Export("offsetX")
   int offsetX;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = 688876963
   )
   @Export("offsetHeight")
   int offsetHeight;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = 2050502779
   )
   @Export("offsetY")
   int offsetY;
   @ObfuscatedName("ay")
   @Export("boolean2")
   public boolean boolean2;
   @ObfuscatedName("ai")
   @Export("isSolid")
   boolean isSolid;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = 2040555547
   )
   @Export("int3")
   public int int3;
   @ObfuscatedName("ah")
   @Export("impostorIds")
   public int[] impostorIds;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = 1929572175
   )
   @Export("varpId")
   int varpId;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = 2109158551
   )
   @Export("configId")
   int configId;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 492183817
   )
   @Export("ambientSoundId")
   public int ambientSoundId;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = 1274074531
   )
   @Export("int4")
   public int int4;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = 103125545
   )
   @Export("int5")
   public int int5;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = 1679061985
   )
   @Export("int6")
   public int int6;
   @ObfuscatedName("ao")
   public int[] field3540;
   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "Lgr;"
   )
   IterableHashTable field3558;

   static {
      ObjectDefinition_isLowDetail = false;
      objects = new NodeCache(4096);
      field3512 = new NodeCache(500);
      cachedModels = new NodeCache(30);
      field3521 = new NodeCache(30);
      field3508 = new ModelData[4];
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

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1705964802"
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
      signature = "(Lgh;I)V",
      garbageValue = "1607095283"
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

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lgh;IB)V",
      garbageValue = "0"
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
            this.field3540 = new int[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field3540[var4] = var1.readUnsignedShort();
            }
         } else if(var2 == 81) {
            this.clipType = var1.readUnsignedByte() * 256;
         } else if(var2 == 82) {
            this.mapIconId = var1.readUnsignedShort();
         } else if(var2 == 249) {
            this.field3558 = ItemContainer.readStringIntParameters(var1, this.field3558);
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

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-2062698873"
   )
   public final boolean method4662(int var1) {
      if(this.objectTypes != null) {
         for(int var4 = 0; var4 < this.objectTypes.length; ++var4) {
            if(this.objectTypes[var4] == var1) {
               return field3551.tryLoadRecord(this.objectModels[var4] & 65535, 0);
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
            var2 &= field3551.tryLoadRecord(this.objectModels[var3] & 65535, 0);
         }

         return var2;
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(S)Z",
      garbageValue = "-26054"
   )
   public final boolean method4663() {
      if(this.objectModels == null) {
         return true;
      } else {
         boolean var1 = true;

         for(int var2 = 0; var2 < this.objectModels.length; ++var2) {
            var1 &= field3551.tryLoadRecord(this.objectModels[var2] & 65535, 0);
         }

         return var1;
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II[[IIIII)Lel;",
      garbageValue = "-1567857566"
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
            var10.field1718 = (short)(this.ambient + 64);
            var10.contrast = (short)(this.contrast + 768);
            var10.computeNormals();
            var9 = var10;
         }

         cachedModels.put((CacheableNode)var9, var7);
      }

      if(this.nonFlatShading) {
         var9 = ((ModelData)var9).method2468();
      }

      if(this.clipType >= 0) {
         if(var9 instanceof Model) {
            var9 = ((Model)var9).method2518(var3, var4, var5, var6, true, this.clipType);
         } else if(var9 instanceof ModelData) {
            var9 = ((ModelData)var9).method2440(var3, var4, var5, var6, true, this.clipType);
         }
      }

      return (Renderable)var9;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II[[IIIII)Lef;",
      garbageValue = "-922704609"
   )
   public final Model method4665(int var1, int var2, int[][] var3, int var4, int var5, int var6) {
      long var7;
      if(this.objectTypes == null) {
         var7 = (long)(var2 + (this.id << 10));
      } else {
         var7 = (long)(var2 + (var1 << 3) + (this.id << 10));
      }

      Model var9 = (Model)field3521.get(var7);
      if(var9 == null) {
         ModelData var10 = this.getModel(var1, var2);
         if(var10 == null) {
            return null;
         }

         var9 = var10.light(this.ambient + 64, this.contrast + 768, -50, -10, -50);
         field3521.put(var9, var7);
      }

      if(this.clipType >= 0) {
         var9 = var9.method2518(var3, var4, var5, var6, true, this.clipType);
      }

      return var9;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II[[IIIILjj;II)Lef;",
      garbageValue = "-1814334045"
   )
   public final Model method4666(int var1, int var2, int[][] var3, int var4, int var5, int var6, Sequence var7, int var8) {
      long var9;
      if(this.objectTypes == null) {
         var9 = (long)(var2 + (this.id << 10));
      } else {
         var9 = (long)(var2 + (var1 << 3) + (this.id << 10));
      }

      Model var11 = (Model)field3521.get(var9);
      if(var11 == null) {
         ModelData var12 = this.getModel(var1, var2);
         if(var12 == null) {
            return null;
         }

         var11 = var12.light(this.ambient + 64, this.contrast + 768, -50, -10, -50);
         field3521.put(var11, var9);
      }

      if(var7 == null && this.clipType == -1) {
         return var11;
      } else {
         if(var7 != null) {
            var11 = var7.method4838(var11, var8, var2);
         } else {
            var11 = var11.method2509(true);
         }

         if(this.clipType >= 0) {
            var11 = var11.method2518(var3, var4, var5, var6, false, this.clipType);
         }

         return var11;
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIB)Ldm;",
      garbageValue = "-1"
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

            var3 = (ModelData)field3512.get((long)var7);
            if(var3 == null) {
               var3 = ModelData.method2428(field3551, var7 & 65535, 0);
               if(var3 == null) {
                  return null;
               }

               if(var4) {
                  var3.method2429();
               }

               field3512.put(var3, (long)var7);
            }

            if(var5 > 1) {
               field3508[var6] = var3;
            }
         }

         if(var5 > 1) {
            var3 = new ModelData(field3508, var5);
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

         var3 = (ModelData)field3512.get((long)var5);
         if(var3 == null) {
            var3 = ModelData.method2428(field3551, var5 & 65535, 0);
            if(var3 == null) {
               return null;
            }

            if(var10) {
               var3.method2429();
            }

            field3512.put(var3, (long)var5);
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
         var8.method2425(256);
         var8.method2426(45, 0, -45);
      }

      var2 &= 3;
      if(var2 == 1) {
         var8.method2460();
      } else if(var2 == 2) {
         var8.method2452();
      } else if(var2 == 3) {
         var8.method2474();
      }

      if(this.recolorToFind != null) {
         for(var7 = 0; var7 < this.recolorToFind.length; ++var7) {
            var8.recolor(this.recolorToFind[var7], this.recolorToReplace[var7]);
         }
      }

      if(this.textureToFind != null) {
         for(var7 = 0; var7 < this.textureToFind.length; ++var7) {
            var8.method2437(this.textureToFind[var7], this.textureToReplace[var7]);
         }
      }

      if(var4) {
         var8.method2487(this.modelSizeX, this.modelSizeHeight, this.modelSizeY);
      }

      if(var11) {
         var8.method2426(this.offsetX, this.offsetHeight, this.offsetY);
      }

      return var8;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)Ljf;",
      garbageValue = "1746208980"
   )
   @Export("getImpostor")
   public final ObjectComposition getImpostor() {
      int var1 = -1;
      if(this.varpId != -1) {
         var1 = class36.getVarbit(this.varpId);
      } else if(this.configId != -1) {
         var1 = VarpSettingsStore.widgetSettings[this.configId];
      }

      int var2;
      if(var1 >= 0 && var1 < this.impostorIds.length - 1) {
         var2 = this.impostorIds[var1];
      } else {
         var2 = this.impostorIds[this.impostorIds.length - 1];
      }

      return var2 != -1?CacheFile.getObjectDefinition(var2):null;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1466930188"
   )
   public int method4668(int var1, int var2) {
      return GraphicsObject.method1615(this.field3558, var1, var2);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)Ljava/lang/String;",
      garbageValue = "-1283434496"
   )
   public String method4685(int var1, String var2) {
      return class192.method3599(this.field3558, var1, var2);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1733650970"
   )
   public boolean method4670() {
      if(this.impostorIds == null) {
         return this.ambientSoundId != -1 || this.field3540 != null;
      } else {
         for(int var1 = 0; var1 < this.impostorIds.length; ++var1) {
            if(this.impostorIds[var1] != -1) {
               ObjectComposition var2 = CacheFile.getObjectDefinition(this.impostorIds[var1]);
               if(var2.ambientSoundId != -1 || var2.field3540 != null) {
                  return true;
               }
            }
         }

         return false;
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-762498911"
   )
   public static void method4706() {
      class293.classInfos = new CombatInfoList();
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(CI)Z",
      garbageValue = "-655005255"
   )
   public static boolean method4664(char var0) {
      return var0 >= 'A' && var0 <= 'Z' || var0 >= 'a' && var0 <= 'z';
   }
}
