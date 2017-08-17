import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ih")
@Implements("ObjectComposition")
public class ObjectComposition extends CacheableNode {
   @ObfuscatedName("j")
   public static boolean field3451;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lgs;"
   )
   @Export("objects")
   static NodeCache objects;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lia;"
   )
   public static IndexDataBase field3427;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lia;"
   )
   @Export("objects_ref")
   public static IndexDataBase objects_ref;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lgs;"
   )
   static NodeCache field3431;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lgs;"
   )
   @Export("cachedModels")
   static NodeCache cachedModels;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lgs;"
   )
   public static NodeCache field3476;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "[Ldi;"
   )
   static ModelData[] field3432;
   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "Lgd;"
   )
   IterableHashTable field3475;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = -494259223
   )
   @Export("varpId")
   int varpId;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1740542703
   )
   public int field3445;
   @ObfuscatedName("b")
   @Export("objectModels")
   int[] objectModels;
   @ObfuscatedName("o")
   @Export("objectTypes")
   int[] objectTypes;
   @ObfuscatedName("ah")
   @Export("impostorIds")
   public int[] impostorIds;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = -592465317
   )
   @Export("ambientSoundId")
   public int ambientSoundId;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = -511163127
   )
   @Export("configId")
   int configId;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = -887304169
   )
   public int field3466;
   @ObfuscatedName("m")
   @Export("name")
   public String name;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1449386501
   )
   @Export("id")
   public int id;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = 78272511
   )
   @Export("mapIconId")
   public int mapIconId;
   @ObfuscatedName("ak")
   public int[] field3474;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1760776239
   )
   @Export("sizeX")
   public int sizeX;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -602764509
   )
   @Export("interactType")
   public int interactType;
   @ObfuscatedName("av")
   @Export("isRotated")
   boolean isRotated;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1537093173
   )
   @Export("sizeY")
   public int sizeY;
   @ObfuscatedName("an")
   @Export("actions")
   public String[] actions;
   @ObfuscatedName("y")
   public boolean field3444;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = 61596337
   )
   public int field3437;
   @ObfuscatedName("k")
   @Export("nonFlatShading")
   boolean nonFlatShading;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1668838979
   )
   @Export("clipType")
   int clipType;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = -1027081593
   )
   public int field3472;
   @ObfuscatedName("q")
   @Export("modelClipped")
   public boolean modelClipped;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -610558603
   )
   @Export("ambient")
   int ambient;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -906302673
   )
   @Export("contrast")
   int contrast;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = 1301248949
   )
   public int field3434;
   @ObfuscatedName("al")
   @Export("isSolid")
   boolean isSolid;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1304114463
   )
   @Export("animationId")
   public int animationId;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = 61150083
   )
   @Export("modelSizeX")
   int modelSizeX;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -633303057
   )
   public int field3450;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 1980597405
   )
   @Export("modelSizeHeight")
   int modelSizeHeight;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = 456286279
   )
   @Export("modelSizeY")
   int modelSizeY;
   @ObfuscatedName("i")
   @Export("recolorToFind")
   short[] recolorToFind;
   @ObfuscatedName("ab")
   @Export("clipped")
   public boolean clipped;
   @ObfuscatedName("r")
   @Export("textureToFind")
   short[] textureToFind;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = 553984683
   )
   @Export("mapSceneId")
   public int mapSceneId;
   @ObfuscatedName("s")
   @Export("recolorToReplace")
   short[] recolorToReplace;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = 431160341
   )
   @Export("offsetX")
   int offsetX;
   @ObfuscatedName("e")
   @Export("textureToReplace")
   short[] textureToReplace;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = -762802981
   )
   @Export("offsetHeight")
   int offsetHeight;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = -1431583333
   )
   @Export("offsetY")
   int offsetY;
   @ObfuscatedName("az")
   public boolean field3430;

   static {
      field3451 = false;
      objects = new NodeCache(4096);
      field3476 = new NodeCache(500);
      cachedModels = new NodeCache(30);
      field3431 = new NodeCache(30);
      field3432 = new ModelData[4];
   }

   ObjectComposition() {
      this.name = "null";
      this.sizeX = 1;
      this.sizeY = 1;
      this.interactType = 2;
      this.field3444 = true;
      this.field3445 = -1;
      this.clipType = -1;
      this.nonFlatShading = false;
      this.modelClipped = false;
      this.animationId = -1;
      this.field3450 = 16;
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
      this.field3430 = false;
      this.isSolid = false;
      this.field3466 = -1;
      this.varpId = -1;
      this.configId = -1;
      this.ambientSoundId = -1;
      this.field3437 = 0;
      this.field3472 = 0;
      this.field3434 = 0;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)Lih;",
      garbageValue = "-1702007300"
   )
   @Export("getImpostor")
   public final ObjectComposition getImpostor() {
      int var1 = -1;
      if(this.varpId != -1) {
         var1 = BaseVarType.method12(this.varpId);
      } else if(this.configId != -1) {
         var1 = class212.widgetSettings[this.configId];
      }

      int var2;
      if(var1 >= 0 && var1 < this.impostorIds.length - 1) {
         var2 = this.impostorIds[var1];
      } else {
         var2 = this.impostorIds[this.impostorIds.length - 1];
      }

      return var2 != -1?class37.getObjectDefinition(var2):null;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lfb;IB)V",
      garbageValue = "16"
   )
   @Export("loadData")
   void loadData(Buffer var1, int var2) {
      int var3;
      int var4;
      if(var2 == 1) {
         var3 = var1.readUnsignedByte();
         if(var3 > 0) {
            if(this.objectModels != null && !field3451) {
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
            if(this.objectModels != null && !field3451) {
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
         this.field3444 = false;
      } else if(var2 == 18) {
         this.field3444 = false;
      } else if(var2 == 19) {
         this.field3445 = var1.readUnsignedByte();
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
         this.field3450 = var1.readUnsignedByte();
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
         this.field3430 = true;
      } else if(var2 == 74) {
         this.isSolid = true;
      } else if(var2 == 75) {
         this.field3466 = var1.readUnsignedByte();
      } else if(var2 != 77 && var2 != 92) {
         if(var2 == 78) {
            this.ambientSoundId = var1.readUnsignedShort();
            this.field3437 = var1.readUnsignedByte();
         } else if(var2 == 79) {
            this.field3472 = var1.readUnsignedShort();
            this.field3434 = var1.readUnsignedShort();
            this.field3437 = var1.readUnsignedByte();
            var3 = var1.readUnsignedByte();
            this.field3474 = new int[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field3474[var4] = var1.readUnsignedShort();
            }
         } else if(var2 == 81) {
            this.clipType = var1.readUnsignedByte() * 256;
         } else if(var2 == 82) {
            this.mapIconId = var1.readUnsignedShort();
         } else if(var2 == 249) {
            this.field3475 = FileRequest.method4109(var1, this.field3475);
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

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(III)Ldi;",
      garbageValue = "-463985057"
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

            var3 = (ModelData)field3476.get((long)var7);
            if(var3 == null) {
               var3 = ModelData.method2431(field3427, var7 & '\uffff', 0);
               if(var3 == null) {
                  return null;
               }

               if(var4) {
                  var3.method2476();
               }

               field3476.put(var3, (long)var7);
            }

            if(var5 > 1) {
               field3432[var6] = var3;
            }
         }

         if(var5 > 1) {
            var3 = new ModelData(field3432, var5);
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

         var3 = (ModelData)field3476.get((long)var5);
         if(var3 == null) {
            var3 = ModelData.method2431(field3427, var5 & '\uffff', 0);
            if(var3 == null) {
               return null;
            }

            if(var10) {
               var3.method2476();
            }

            field3476.put(var3, (long)var5);
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
         var8.method2477(256);
         var8.method2444(45, 0, -45);
      }

      var2 &= 3;
      if(var2 == 1) {
         var8.method2440();
      } else if(var2 == 2) {
         var8.method2441();
      } else if(var2 == 3) {
         var8.method2442();
      }

      if(this.recolorToFind != null) {
         for(var7 = 0; var7 < this.recolorToFind.length; ++var7) {
            var8.recolor(this.recolorToFind[var7], this.recolorToReplace[var7]);
         }
      }

      if(this.textureToFind != null) {
         for(var7 = 0; var7 < this.textureToFind.length; ++var7) {
            var8.method2446(this.textureToFind[var7], this.textureToReplace[var7]);
         }
      }

      if(var4) {
         var8.method2448(this.modelSizeX, this.modelSizeHeight, this.modelSizeY);
      }

      if(var11) {
         var8.method2444(this.offsetX, this.offsetHeight, this.offsetY);
      }

      return var8;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1241415587"
   )
   @Export("post")
   void post() {
      if(this.field3445 == -1) {
         this.field3445 = 0;
         if(this.objectModels != null && (this.objectTypes == null || this.objectTypes[0] == 10)) {
            this.field3445 = 1;
         }

         for(int var1 = 0; var1 < 5; ++var1) {
            if(this.actions[var1] != null) {
               this.field3445 = 1;
            }
         }
      }

      if(this.field3466 == -1) {
         this.field3466 = this.interactType != 0?1:0;
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lfb;I)V",
      garbageValue = "-2133164766"
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
      signature = "(II[[IIIILjf;II)Leo;",
      garbageValue = "-724992551"
   )
   public final Model method4563(int var1, int var2, int[][] var3, int var4, int var5, int var6, Sequence var7, int var8) {
      long var9;
      if(this.objectTypes == null) {
         var9 = (long)(var2 + (this.id << 10));
      } else {
         var9 = (long)(var2 + (var1 << 3) + (this.id << 10));
      }

      Model var11 = (Model)field3431.get(var9);
      if(var11 == null) {
         ModelData var12 = this.getModel(var1, var2);
         if(var12 == null) {
            return null;
         }

         var11 = var12.light(this.ambient + 64, this.contrast + 768, -50, -10, -50);
         field3431.put(var11, var9);
      }

      if(var7 == null && this.clipType == -1) {
         return var11;
      } else {
         if(var7 != null) {
            var11 = var7.method4729(var11, var8, var2);
         } else {
            var11 = var11.method2525(true);
         }

         if(this.clipType >= 0) {
            var11 = var11.method2524(var3, var4, var5, var6, false, this.clipType);
         }

         return var11;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1722192040"
   )
   public final boolean method4573() {
      if(this.objectModels == null) {
         return true;
      } else {
         boolean var1 = true;

         for(int var2 = 0; var2 < this.objectModels.length; ++var2) {
            var1 &= field3427.method4115(this.objectModels[var2] & '\uffff', 0);
         }

         return var1;
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "1658091569"
   )
   public final boolean method4559(int var1) {
      if(this.objectTypes != null) {
         for(int var4 = 0; var4 < this.objectTypes.length; ++var4) {
            if(this.objectTypes[var4] == var1) {
               return field3427.method4115(this.objectModels[var4] & '\uffff', 0);
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
            var2 &= field3427.method4115(this.objectModels[var3] & '\uffff', 0);
         }

         return var2;
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "1"
   )
   public boolean method4579() {
      if(this.impostorIds == null) {
         return this.ambientSoundId != -1 || this.field3474 != null;
      } else {
         for(int var1 = 0; var1 < this.impostorIds.length; ++var1) {
            if(this.impostorIds[var1] != -1) {
               ObjectComposition var2 = class37.getObjectDefinition(this.impostorIds[var1]);
               if(var2.ambientSoundId != -1 || var2.field3474 != null) {
                  return true;
               }
            }
         }

         return false;
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II[[IIIII)Leq;",
      garbageValue = "-852390499"
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
            var10.field1832 = (short)(this.ambient + 64);
            var10.contrast = (short)(this.contrast + 768);
            var10.computeNormals();
            var9 = var10;
         }

         cachedModels.put((CacheableNode)var9, var7);
      }

      if(this.nonFlatShading) {
         var9 = ((ModelData)var9).method2437();
      }

      if(this.clipType >= 0) {
         if(var9 instanceof Model) {
            var9 = ((Model)var9).method2524(var3, var4, var5, var6, true, this.clipType);
         } else if(var9 instanceof ModelData) {
            var9 = ((ModelData)var9).method2438(var3, var4, var5, var6, true, this.clipType);
         }
      }

      return (Renderable)var9;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(II[[IIIII)Leo;",
      garbageValue = "2043506346"
   )
   public final Model method4560(int var1, int var2, int[][] var3, int var4, int var5, int var6) {
      long var7;
      if(this.objectTypes == null) {
         var7 = (long)(var2 + (this.id << 10));
      } else {
         var7 = (long)(var2 + (var1 << 3) + (this.id << 10));
      }

      Model var9 = (Model)field3431.get(var7);
      if(var9 == null) {
         ModelData var10 = this.getModel(var1, var2);
         if(var10 == null) {
            return null;
         }

         var9 = var10.light(this.ambient + 64, this.contrast + 768, -50, -10, -50);
         field3431.put(var9, var7);
      }

      if(this.clipType >= 0) {
         var9 = var9.method2524(var3, var4, var5, var6, true, this.clipType);
      }

      return var9;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "535715521"
   )
   public int method4566(int var1, int var2) {
      return ChatLineBuffer.method1892(this.field3475, var1, var2);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)Ljava/lang/String;",
      garbageValue = "1140843772"
   )
   public String method4567(int var1, String var2) {
      return class29.method261(this.field3475, var1, var2);
   }
}
