import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iq")
@Implements("ObjectComposition")
public class ObjectComposition extends CacheableNode {
   @ObfuscatedName("i")
   public static boolean field3477;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lgp;"
   )
   @Export("objects")
   public static NodeCache objects;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lii;"
   )
   @Export("objects_ref")
   public static IndexDataBase objects_ref;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lgp;"
   )
   public static NodeCache field3442;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lgp;"
   )
   @Export("cachedModels")
   public static NodeCache cachedModels;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lgp;"
   )
   public static NodeCache field3437;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "[Lde;"
   )
   static ModelData[] field3472;
   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "Lgi;"
   )
   IterableHashTable field3462;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = -1474687911
   )
   @Export("varpId")
   int varpId;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1737412073
   )
   public int field3454;
   @ObfuscatedName("s")
   @Export("objectModels")
   int[] objectModels;
   @ObfuscatedName("d")
   @Export("objectTypes")
   int[] objectTypes;
   @ObfuscatedName("aw")
   @Export("impostorIds")
   public int[] impostorIds;
   @ObfuscatedName("l")
   @Export("name")
   public String name;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = -1135662235
   )
   @Export("ambientSoundId")
   public int ambientSoundId;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = -2040988665
   )
   @Export("configId")
   int configId;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -1706729411
   )
   public int field3474;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1944194945
   )
   @Export("id")
   public int id;
   @ObfuscatedName("ae")
   public int[] field3482;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = 564743519
   )
   @Export("mapIconId")
   public int mapIconId;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -961004175
   )
   @Export("sizeX")
   public int sizeX;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 261582077
   )
   @Export("interactType")
   public int interactType;
   @ObfuscatedName("ab")
   @Export("isRotated")
   boolean isRotated;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -707363895
   )
   @Export("sizeY")
   public int sizeY;
   @ObfuscatedName("p")
   public boolean field3452;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = 89450639
   )
   public int field3479;
   @ObfuscatedName("h")
   @Export("nonFlatShading")
   boolean nonFlatShading;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 2085095829
   )
   @Export("clipType")
   int clipType;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = 1755227219
   )
   public int field3480;
   @ObfuscatedName("f")
   @Export("modelClipped")
   public boolean modelClipped;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = -1841880795
   )
   @Export("ambient")
   int ambient;
   @ObfuscatedName("al")
   @Export("actions")
   public String[] actions;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -926458287
   )
   @Export("contrast")
   int contrast;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = 1477819861
   )
   public int field3461;
   @ObfuscatedName("av")
   @Export("isSolid")
   boolean isSolid;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1507110641
   )
   @Export("animationId")
   public int animationId;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = -1516637045
   )
   @Export("modelSizeX")
   int modelSizeX;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1192388071
   )
   public int field3458;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = -873522669
   )
   @Export("modelSizeHeight")
   int modelSizeHeight;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = 1719486743
   )
   @Export("modelSizeY")
   int modelSizeY;
   @ObfuscatedName("t")
   @Export("recolorToFind")
   short[] recolorToFind;
   @ObfuscatedName("am")
   @Export("clipped")
   public boolean clipped;
   @ObfuscatedName("v")
   @Export("textureToFind")
   short[] textureToFind;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = -960269973
   )
   @Export("mapSceneId")
   public int mapSceneId;
   @ObfuscatedName("y")
   @Export("recolorToReplace")
   short[] recolorToReplace;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = 1731193769
   )
   @Export("offsetX")
   int offsetX;
   @ObfuscatedName("c")
   @Export("textureToReplace")
   short[] textureToReplace;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = -1617959171
   )
   @Export("offsetHeight")
   int offsetHeight;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = 591823043
   )
   @Export("offsetY")
   int offsetY;
   @ObfuscatedName("ay")
   public boolean field3451;

   static {
      field3477 = false;
      objects = new NodeCache(4096);
      field3437 = new NodeCache(500);
      cachedModels = new NodeCache(30);
      field3442 = new NodeCache(30);
      field3472 = new ModelData[4];
   }

   ObjectComposition() {
      this.name = "null";
      this.sizeX = 1;
      this.sizeY = 1;
      this.interactType = 2;
      this.field3452 = true;
      this.field3454 = -1;
      this.clipType = -1;
      this.nonFlatShading = false;
      this.modelClipped = false;
      this.animationId = -1;
      this.field3458 = 16;
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
      this.field3451 = false;
      this.isSolid = false;
      this.field3474 = -1;
      this.varpId = -1;
      this.configId = -1;
      this.ambientSoundId = -1;
      this.field3479 = 0;
      this.field3480 = 0;
      this.field3461 = 0;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)Liq;",
      garbageValue = "-31394747"
   )
   @Export("getImpostor")
   public final ObjectComposition getImpostor() {
      int var1 = -1;
      if(this.varpId != -1) {
         var1 = WidgetNode.method1121(this.varpId);
      } else if(this.configId != -1) {
         var1 = class212.widgetSettings[this.configId];
      }

      int var2;
      if(var1 >= 0 && var1 < this.impostorIds.length - 1) {
         var2 = this.impostorIds[var1];
      } else {
         var2 = this.impostorIds[this.impostorIds.length - 1];
      }

      return var2 != -1?GameObject.getObjectDefinition(var2):null;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lfp;IS)V",
      garbageValue = "11636"
   )
   @Export("loadData")
   void loadData(Buffer var1, int var2) {
      int var3;
      int var4;
      if(var2 == 1) {
         var3 = var1.readUnsignedByte();
         if(var3 > 0) {
            if(this.objectModels != null && !field3477) {
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
            if(this.objectModels != null && !field3477) {
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
         this.field3452 = false;
      } else if(var2 == 18) {
         this.field3452 = false;
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
         if(this.animationId == '\uffff') {
            this.animationId = -1;
         }
      } else if(var2 == 27) {
         this.interactType = 1;
      } else if(var2 == 28) {
         this.field3458 = var1.readUnsignedByte();
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
         this.field3451 = true;
      } else if(var2 == 74) {
         this.isSolid = true;
      } else if(var2 == 75) {
         this.field3474 = var1.readUnsignedByte();
      } else if(var2 != 77 && var2 != 92) {
         if(var2 == 78) {
            this.ambientSoundId = var1.readUnsignedShort();
            this.field3479 = var1.readUnsignedByte();
         } else if(var2 == 79) {
            this.field3480 = var1.readUnsignedShort();
            this.field3461 = var1.readUnsignedShort();
            this.field3479 = var1.readUnsignedByte();
            var3 = var1.readUnsignedByte();
            this.field3482 = new int[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field3482[var4] = var1.readUnsignedShort();
            }
         } else if(var2 == 81) {
            this.clipType = var1.readUnsignedByte() * 256;
         } else if(var2 == 82) {
            this.mapIconId = var1.readUnsignedShort();
         } else if(var2 == 249) {
            this.field3462 = class34.method516(var1, this.field3462);
         }
      } else {
         this.varpId = var1.readUnsignedShort();
         if(this.varpId == '\uffff') {
            this.varpId = -1;
         }

         this.configId = var1.readUnsignedShort();
         if(this.configId == '\uffff') {
            this.configId = -1;
         }

         var3 = -1;
         if(var2 == 92) {
            var3 = var1.readUnsignedShort();
            if(var3 == '\uffff') {
               var3 = -1;
            }
         }

         var4 = var1.readUnsignedByte();
         this.impostorIds = new int[var4 + 2];

         for(int var5 = 0; var5 <= var4; ++var5) {
            this.impostorIds[var5] = var1.readUnsignedShort();
            if(this.impostorIds[var5] == '\uffff') {
               this.impostorIds[var5] = -1;
            }
         }

         this.impostorIds[var4 + 1] = var3;
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIB)Lde;",
      garbageValue = "53"
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

            var3 = (ModelData)field3437.get((long)var7);
            if(var3 == null) {
               var3 = ModelData.method2414(class228.field3150, var7 & '\uffff', 0);
               if(var3 == null) {
                  return null;
               }

               if(var4) {
                  var3.method2428();
               }

               field3437.put(var3, (long)var7);
            }

            if(var5 > 1) {
               field3472[var6] = var3;
            }
         }

         if(var5 > 1) {
            var3 = new ModelData(field3472, var5);
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

         var3 = (ModelData)field3437.get((long)var5);
         if(var3 == null) {
            var3 = ModelData.method2414(class228.field3150, var5 & '\uffff', 0);
            if(var3 == null) {
               return null;
            }

            if(var10) {
               var3.method2428();
            }

            field3437.put(var3, (long)var5);
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
         var8.method2472(256);
         var8.method2453(45, 0, -45);
      }

      var2 &= 3;
      if(var2 == 1) {
         var8.method2421();
      } else if(var2 == 2) {
         var8.method2419();
      } else if(var2 == 3) {
         var8.method2422();
      }

      if(this.recolorToFind != null) {
         for(var7 = 0; var7 < this.recolorToFind.length; ++var7) {
            var8.recolor(this.recolorToFind[var7], this.recolorToReplace[var7]);
         }
      }

      if(this.textureToFind != null) {
         for(var7 = 0; var7 < this.textureToFind.length; ++var7) {
            var8.method2465(this.textureToFind[var7], this.textureToReplace[var7]);
         }
      }

      if(var4) {
         var8.method2466(this.modelSizeX, this.modelSizeHeight, this.modelSizeY);
      }

      if(var11) {
         var8.method2453(this.offsetX, this.offsetHeight, this.offsetY);
      }

      return var8;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "403526149"
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

      if(this.field3474 == -1) {
         this.field3474 = this.interactType != 0?1:0;
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lfp;I)V",
      garbageValue = "1095300728"
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

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II[[IIIILjw;II)Lem;",
      garbageValue = "-2124338028"
   )
   public final Model method4539(int var1, int var2, int[][] var3, int var4, int var5, int var6, Sequence var7, int var8) {
      long var9;
      if(this.objectTypes == null) {
         var9 = (long)(var2 + (this.id << 10));
      } else {
         var9 = (long)(var2 + (var1 << 3) + (this.id << 10));
      }

      Model var11 = (Model)field3442.get(var9);
      if(var11 == null) {
         ModelData var12 = this.getModel(var1, var2);
         if(var12 == null) {
            return null;
         }

         var11 = var12.light(this.ambient + 64, this.contrast + 768, -50, -10, -50);
         field3442.put(var11, var9);
      }

      if(var7 == null && this.clipType == -1) {
         return var11;
      } else {
         if(var7 != null) {
            var11 = var7.method4668(var11, var8, var2);
         } else {
            var11 = var11.method2511(true);
         }

         if(this.clipType >= 0) {
            var11 = var11.method2510(var3, var4, var5, var6, false, this.clipType);
         }

         return var11;
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1286849657"
   )
   public final boolean method4521() {
      if(this.objectModels == null) {
         return true;
      } else {
         boolean var1 = true;

         for(int var2 = 0; var2 < this.objectModels.length; ++var2) {
            var1 &= class228.field3150.method4137(this.objectModels[var2] & '\uffff', 0);
         }

         return var1;
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "1204445014"
   )
   public final boolean method4520(int var1) {
      if(this.objectTypes != null) {
         for(int var4 = 0; var4 < this.objectTypes.length; ++var4) {
            if(this.objectTypes[var4] == var1) {
               return class228.field3150.method4137(this.objectModels[var4] & '\uffff', 0);
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
            var2 &= class228.field3150.method4137(this.objectModels[var3] & '\uffff', 0);
         }

         return var2;
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(II[[IIIII)Lem;",
      garbageValue = "-1072931149"
   )
   public final Model method4530(int var1, int var2, int[][] var3, int var4, int var5, int var6) {
      long var7;
      if(this.objectTypes == null) {
         var7 = (long)(var2 + (this.id << 10));
      } else {
         var7 = (long)(var2 + (var1 << 3) + (this.id << 10));
      }

      Model var9 = (Model)field3442.get(var7);
      if(var9 == null) {
         ModelData var10 = this.getModel(var1, var2);
         if(var10 == null) {
            return null;
         }

         var9 = var10.light(this.ambient + 64, this.contrast + 768, -50, -10, -50);
         field3442.put(var9, var7);
      }

      if(this.clipType >= 0) {
         var9 = var9.method2510(var3, var4, var5, var6, true, this.clipType);
      }

      return var9;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(S)Z",
      garbageValue = "-19338"
   )
   public boolean method4516() {
      if(this.impostorIds == null) {
         return this.ambientSoundId != -1 || this.field3482 != null;
      } else {
         for(int var1 = 0; var1 < this.impostorIds.length; ++var1) {
            if(this.impostorIds[var1] != -1) {
               ObjectComposition var2 = GameObject.getObjectDefinition(this.impostorIds[var1]);
               if(var2.ambientSoundId != -1 || var2.field3482 != null) {
                  return true;
               }
            }
         }

         return false;
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II[[IIIII)Lew;",
      garbageValue = "-2016452674"
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
            var10.field1839 = (short)(this.ambient + 64);
            var10.contrast = (short)(this.contrast + 768);
            var10.computeNormals();
            var9 = var10;
         }

         cachedModels.put((CacheableNode)var9, var7);
      }

      if(this.nonFlatShading) {
         var9 = ((ModelData)var9).method2418();
      }

      if(this.clipType >= 0) {
         if(var9 instanceof Model) {
            var9 = ((Model)var9).method2510(var3, var4, var5, var6, true, this.clipType);
         } else if(var9 instanceof ModelData) {
            var9 = ((ModelData)var9).method2423(var3, var4, var5, var6, true, this.clipType);
         }
      }

      return (Renderable)var9;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-161337551"
   )
   public int method4524(int var1, int var2) {
      return class20.method174(this.field3462, var1, var2);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;S)Ljava/lang/String;",
      garbageValue = "7600"
   )
   public String method4528(int var1, String var2) {
      return class43.method653(this.field3462, var1, var2);
   }
}
