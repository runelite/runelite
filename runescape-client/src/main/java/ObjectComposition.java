import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("im")
@Implements("ObjectComposition")
public class ObjectComposition extends CacheableNode {
   @ObfuscatedName("a")
   public static boolean field3441;
   @ObfuscatedName("r")
   @Export("objects")
   public static NodeCache objects;
   @ObfuscatedName("n")
   public static IndexDataBase field3435;
   @ObfuscatedName("j")
   @Export("objects_ref")
   public static IndexDataBase objects_ref;
   @ObfuscatedName("l")
   public static NodeCache field3439;
   @ObfuscatedName("e")
   @Export("cachedModels")
   public static NodeCache cachedModels;
   @ObfuscatedName("v")
   public static NodeCache field3446;
   @ObfuscatedName("s")
   static ModelData[] field3440;
   @ObfuscatedName("ac")
   class186 field3483;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = -545262899
   )
   @Export("varpId")
   int varpId;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1461305159
   )
   public int field3453;
   @ObfuscatedName("p")
   @Export("objectModels")
   int[] objectModels;
   @ObfuscatedName("m")
   @Export("objectTypes")
   int[] objectTypes;
   @ObfuscatedName("av")
   @Export("impostorIds")
   public int[] impostorIds;
   @ObfuscatedName("u")
   @Export("name")
   public String name;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = 1221146509
   )
   @Export("ambientSoundId")
   public int ambientSoundId;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = -1487382565
   )
   public int field3474;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = 1576377359
   )
   @Export("configId")
   int configId;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -329752405
   )
   @Export("id")
   public int id;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = 778018655
   )
   @Export("mapIconId")
   public int mapIconId;
   @ObfuscatedName("ao")
   public int[] field3478;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1687930659
   )
   @Export("sizeX")
   public int sizeX;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1071284907
   )
   @Export("interactType")
   public int interactType;
   @ObfuscatedName("ar")
   @Export("isRotated")
   boolean isRotated;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1924027373
   )
   @Export("sizeY")
   public int sizeY;
   @ObfuscatedName("h")
   public boolean field3452;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = 1021688629
   )
   public int field3457;
   @ObfuscatedName("d")
   @Export("nonFlatShading")
   boolean nonFlatShading;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1631807255
   )
   @Export("clipType")
   int clipType;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = -1053569733
   )
   public int field3480;
   @ObfuscatedName("b")
   @Export("modelClipped")
   public boolean modelClipped;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = 2085921875
   )
   @Export("ambient")
   int ambient;
   @ObfuscatedName("au")
   @Export("actions")
   public String[] actions;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 1664400435
   )
   @Export("contrast")
   int contrast;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = 1925027865
   )
   public int field3481;
   @ObfuscatedName("az")
   @Export("isSolid")
   boolean isSolid;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1010017273
   )
   @Export("animationId")
   public int animationId;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = 1677222665
   )
   @Export("modelSizeX")
   int modelSizeX;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 452793627
   )
   public int field3458;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = -1067809231
   )
   @Export("modelSizeHeight")
   int modelSizeHeight;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = -578643297
   )
   @Export("modelSizeY")
   int modelSizeY;
   @ObfuscatedName("g")
   @Export("recolorToFind")
   short[] recolorToFind;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = -897725733
   )
   @Export("mapSceneId")
   public int mapSceneId;
   @ObfuscatedName("am")
   @Export("clipped")
   public boolean clipped;
   @ObfuscatedName("t")
   @Export("textureToFind")
   short[] textureToFind;
   @ObfuscatedName("k")
   @Export("recolorToReplace")
   short[] recolorToReplace;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = -1230477115
   )
   @Export("offsetX")
   int offsetX;
   @ObfuscatedName("c")
   @Export("textureToReplace")
   short[] textureToReplace;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = -951625413
   )
   @Export("offsetHeight")
   int offsetHeight;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = 1194117601
   )
   @Export("offsetY")
   int offsetY;
   @ObfuscatedName("ad")
   public boolean field3472;

   static {
      field3441 = false;
      objects = new NodeCache(4096);
      field3446 = new NodeCache(500);
      cachedModels = new NodeCache(30);
      field3439 = new NodeCache(30);
      field3440 = new ModelData[4];
   }

   ObjectComposition() {
      this.name = "null";
      this.sizeX = 1;
      this.sizeY = 1;
      this.interactType = 2;
      this.field3452 = true;
      this.field3453 = -1;
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
      this.field3472 = false;
      this.isSolid = false;
      this.field3474 = -1;
      this.varpId = -1;
      this.configId = -1;
      this.ambientSoundId = -1;
      this.field3457 = 0;
      this.field3480 = 0;
      this.field3481 = 0;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)LObjectComposition;",
      garbageValue = "83"
   )
   @Export("getImpostor")
   public final ObjectComposition getImpostor() {
      int var1 = -1;
      if(this.varpId != -1) {
         var1 = class1.method3(this.varpId);
      } else if(this.configId != -1) {
         var1 = class211.widgetSettings[this.configId];
      }

      int var2;
      if(var1 >= 0 && var1 < this.impostorIds.length - 1) {
         var2 = this.impostorIds[var1];
      } else {
         var2 = this.impostorIds[this.impostorIds.length - 1];
      }

      return var2 != -1?PlayerComposition.getObjectDefinition(var2):null;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "1250411708"
   )
   @Export("loadData")
   void loadData(Buffer var1, int var2) {
      int var3;
      int var4;
      if(var2 == 1) {
         var3 = var1.readUnsignedByte();
         if(var3 > 0) {
            if(this.objectModels != null && !field3441) {
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
            if(this.objectModels != null && !field3441) {
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
         this.field3453 = var1.readUnsignedByte();
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
         this.field3472 = true;
      } else if(var2 == 74) {
         this.isSolid = true;
      } else if(var2 == 75) {
         this.field3474 = var1.readUnsignedByte();
      } else if(var2 != 77 && var2 != 92) {
         if(var2 == 78) {
            this.ambientSoundId = var1.readUnsignedShort();
            this.field3457 = var1.readUnsignedByte();
         } else if(var2 == 79) {
            this.field3480 = var1.readUnsignedShort();
            this.field3481 = var1.readUnsignedShort();
            this.field3457 = var1.readUnsignedByte();
            var3 = var1.readUnsignedByte();
            this.field3478 = new int[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field3478[var4] = var1.readUnsignedShort();
            }
         } else if(var2 == 81) {
            this.clipType = var1.readUnsignedByte() * 256;
         } else if(var2 == 82) {
            this.mapIconId = var1.readUnsignedShort();
         } else if(var2 == 249) {
            this.field3483 = World.method1549(var1, this.field3483);
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

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(III)LModelData;",
      garbageValue = "1218142477"
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

            var3 = (ModelData)field3446.get((long)var7);
            if(var3 == null) {
               var3 = ModelData.method2396(field3435, var7 & '\uffff', 0);
               if(var3 == null) {
                  return null;
               }

               if(var4) {
                  var3.method2450();
               }

               field3446.put(var3, (long)var7);
            }

            if(var5 > 1) {
               field3440[var6] = var3;
            }
         }

         if(var5 > 1) {
            var3 = new ModelData(field3440, var5);
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

         var3 = (ModelData)field3446.get((long)var5);
         if(var3 == null) {
            var3 = ModelData.method2396(field3435, var5 & '\uffff', 0);
            if(var3 == null) {
               return null;
            }

            if(var10) {
               var3.method2450();
            }

            field3446.put(var3, (long)var5);
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
         var8.method2435(256);
         var8.method2408(45, 0, -45);
      }

      var2 &= 3;
      if(var2 == 1) {
         var8.method2442();
      } else if(var2 == 2) {
         var8.method2445();
      } else if(var2 == 3) {
         var8.method2406();
      }

      if(this.recolorToFind != null) {
         for(var7 = 0; var7 < this.recolorToFind.length; ++var7) {
            var8.recolor(this.recolorToFind[var7], this.recolorToReplace[var7]);
         }
      }

      if(this.textureToFind != null) {
         for(var7 = 0; var7 < this.textureToFind.length; ++var7) {
            var8.method2410(this.textureToFind[var7], this.textureToReplace[var7]);
         }
      }

      if(var4) {
         var8.method2412(this.modelSizeX, this.modelSizeHeight, this.modelSizeY);
      }

      if(var11) {
         var8.method2408(this.offsetX, this.offsetHeight, this.offsetY);
      }

      return var8;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-901072763"
   )
   @Export("post")
   void post() {
      if(this.field3453 == -1) {
         this.field3453 = 0;
         if(this.objectModels != null && (this.objectTypes == null || this.objectTypes[0] == 10)) {
            this.field3453 = 1;
         }

         for(int var1 = 0; var1 < 5; ++var1) {
            if(this.actions[var1] != null) {
               this.field3453 = 1;
            }
         }
      }

      if(this.field3474 == -1) {
         this.field3474 = this.interactType != 0?1:0;
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-957974841"
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

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II[[IIIILSequence;IB)LModel;",
      garbageValue = "8"
   )
   public final Model method4463(int var1, int var2, int[][] var3, int var4, int var5, int var6, Sequence var7, int var8) {
      long var9;
      if(this.objectTypes == null) {
         var9 = (long)(var2 + (this.id << 10));
      } else {
         var9 = (long)((var1 << 3) + (this.id << 10) + var2);
      }

      Model var11 = (Model)field3439.get(var9);
      if(var11 == null) {
         ModelData var12 = this.getModel(var1, var2);
         if(var12 == null) {
            return null;
         }

         var11 = var12.light(this.ambient + 64, this.contrast + 768, -50, -10, -50);
         field3439.put(var11, var9);
      }

      if(var7 == null && this.clipType == -1) {
         return var11;
      } else {
         if(var7 != null) {
            var11 = var7.method4618(var11, var8, var2);
         } else {
            var11 = var11.method2495(true);
         }

         if(this.clipType >= 0) {
            var11 = var11.method2525(var3, var4, var5, var6, false, this.clipType);
         }

         return var11;
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-50"
   )
   public final boolean method4468() {
      if(this.objectModels == null) {
         return true;
      } else {
         boolean var1 = true;

         for(int var2 = 0; var2 < this.objectModels.length; ++var2) {
            var1 &= field3435.method4085(this.objectModels[var2] & '\uffff', 0);
         }

         return var1;
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "-103"
   )
   public final boolean method4484(int var1) {
      if(this.objectTypes != null) {
         for(int var4 = 0; var4 < this.objectTypes.length; ++var4) {
            if(this.objectTypes[var4] == var1) {
               return field3435.method4085(this.objectModels[var4] & '\uffff', 0);
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
            var2 &= field3435.method4085(this.objectModels[var3] & '\uffff', 0);
         }

         return var2;
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "0"
   )
   public boolean method4475() {
      if(this.impostorIds == null) {
         return this.ambientSoundId != -1 || this.field3478 != null;
      } else {
         for(int var1 = 0; var1 < this.impostorIds.length; ++var1) {
            if(this.impostorIds[var1] != -1) {
               ObjectComposition var2 = PlayerComposition.getObjectDefinition(this.impostorIds[var1]);
               if(var2.ambientSoundId != -1 || var2.field3478 != null) {
                  return true;
               }
            }
         }

         return false;
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II[[IIIIS)LModel;",
      garbageValue = "29886"
   )
   public final Model method4489(int var1, int var2, int[][] var3, int var4, int var5, int var6) {
      long var7;
      if(this.objectTypes == null) {
         var7 = (long)(var2 + (this.id << 10));
      } else {
         var7 = (long)(var2 + (this.id << 10) + (var1 << 3));
      }

      Model var9 = (Model)field3439.get(var7);
      if(var9 == null) {
         ModelData var10 = this.getModel(var1, var2);
         if(var10 == null) {
            return null;
         }

         var9 = var10.light(this.ambient + 64, this.contrast + 768, -50, -10, -50);
         field3439.put(var9, var7);
      }

      if(this.clipType >= 0) {
         var9 = var9.method2525(var3, var4, var5, var6, true, this.clipType);
      }

      return var9;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(II[[IIIIB)LRenderable;",
      garbageValue = "-126"
   )
   @Export("getModel")
   public final Renderable getModel(int var1, int var2, int[][] var3, int var4, int var5, int var6) {
      long var7;
      if(this.objectTypes == null) {
         var7 = (long)(var2 + (this.id << 10));
      } else {
         var7 = (long)((var1 << 3) + (this.id << 10) + var2);
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
            var10.field1818 = (short)(this.ambient + 64);
            var10.contrast = (short)(this.contrast + 768);
            var10.computeNormals();
            var9 = var10;
         }

         cachedModels.put((CacheableNode)var9, var7);
      }

      if(this.nonFlatShading) {
         var9 = ((ModelData)var9).method2401();
      }

      if(this.clipType >= 0) {
         if(var9 instanceof Model) {
            var9 = ((Model)var9).method2525(var3, var4, var5, var6, true, this.clipType);
         } else if(var9 instanceof ModelData) {
            var9 = ((ModelData)var9).method2411(var3, var4, var5, var6, true, this.clipType);
         }
      }

      return (Renderable)var9;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "969752186"
   )
   public int method4474(int var1, int var2) {
      return Timer.method2973(this.field3483, var1, var2);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;B)Ljava/lang/String;",
      garbageValue = "95"
   )
   public String method4501(int var1, String var2) {
      return IndexFile.method3005(this.field3483, var1, var2);
   }
}
