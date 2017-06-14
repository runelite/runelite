import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iv")
@Implements("ObjectComposition")
public class ObjectComposition extends CacheableNode {
   @ObfuscatedName("r")
   @Export("textureToReplace")
   short[] textureToReplace;
   @ObfuscatedName("p")
   static IndexDataBase field3442;
   @ObfuscatedName("i")
   static IndexDataBase field3443;
   @ObfuscatedName("j")
   static NodeCache field3444;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1835238747
   )
   @Export("sizeY")
   public int sizeY;
   @ObfuscatedName("m")
   static NodeCache field3446;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1434414063
   )
   int field3447;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = -1745544689
   )
   @Export("offsetHeight")
   int offsetHeight;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1025766633
   )
   public int field3449;
   @ObfuscatedName("x")
   @Export("recolorToFind")
   short[] recolorToFind;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = 484508091
   )
   @Export("modelSizeY")
   int modelSizeY;
   @ObfuscatedName("c")
   static NodeCache field3452;
   @ObfuscatedName("k")
   @Export("clipped")
   public boolean clipped;
   @ObfuscatedName("a")
   @Export("recolorToReplace")
   short[] recolorToReplace;
   @ObfuscatedName("y")
   @Export("textureToFind")
   short[] textureToFind;
   @ObfuscatedName("al")
   public boolean field3456;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 680748713
   )
   @Export("sizeX")
   public int sizeX;
   @ObfuscatedName("o")
   @Export("name")
   public String name;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1780565769
   )
   public int field3459;
   @ObfuscatedName("t")
   public boolean field3460;
   @ObfuscatedName("z")
   static ModelData[] field3461;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = -291340909
   )
   @Export("offsetY")
   int offsetY;
   @ObfuscatedName("q")
   @Export("nonFlatShading")
   boolean nonFlatShading;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -2078393801
   )
   public int field3464;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 48358015
   )
   @Export("animationId")
   public int animationId;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -942849743
   )
   public int field3466;
   @ObfuscatedName("f")
   public static NodeCache field3467;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -1039882303
   )
   @Export("contrast")
   int contrast;
   @ObfuscatedName("ad")
   @Export("actions")
   public String[] actions;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = -1785333459
   )
   @Export("mapIconId")
   public int mapIconId;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = -737792825
   )
   @Export("mapSceneId")
   public int mapSceneId;
   @ObfuscatedName("an")
   @Export("isRotated")
   boolean isRotated;
   @ObfuscatedName("n")
   static boolean field3473;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = -46826203
   )
   @Export("modelSizeX")
   int modelSizeX;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = 152234301
   )
   @Export("modelSizeHeight")
   int modelSizeHeight;
   @ObfuscatedName("am")
   public boolean field3476;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 1183980493
   )
   @Export("ambient")
   int ambient;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = -1877523831
   )
   @Export("offsetX")
   int offsetX;
   @ObfuscatedName("ap")
   public int[] field3479;
   @ObfuscatedName("g")
   @Export("objectModels")
   int[] objectModels;
   @ObfuscatedName("ac")
   @Export("isSolid")
   boolean isSolid;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = 1494582639
   )
   public int field3482;
   @ObfuscatedName("av")
   @Export("impostorIds")
   public int[] impostorIds;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = 265177115
   )
   @Export("varpId")
   int varpId;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = -1572212381
   )
   @Export("configId")
   int configId;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = -1278241345
   )
   @Export("ambientSoundId")
   public int ambientSoundId;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = -7986745
   )
   public int field3487;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = -2100474241
   )
   public int field3488;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = 2002369511
   )
   public int field3489;
   @ObfuscatedName("e")
   @Export("objectTypes")
   int[] objectTypes;
   @ObfuscatedName("ai")
   class186 field3491;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "1678261209"
   )
   void method4540(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.loadData(var1, var2);
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-522709106"
   )
   public final boolean method4542(int var1) {
      if(this.objectTypes != null) {
         for(int var4 = 0; var4 < this.objectTypes.length; ++var4) {
            if(this.objectTypes[var4] == var1) {
               return field3443.method4127(this.objectModels[var4] & '\uffff', 0);
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
            var2 &= field3443.method4127(this.objectModels[var3] & '\uffff', 0);
         }

         return var2;
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "926490365"
   )
   public final boolean method4543() {
      if(this.objectModels == null) {
         return true;
      } else {
         boolean var1 = true;

         for(int var2 = 0; var2 < this.objectModels.length; ++var2) {
            var1 &= field3443.method4127(this.objectModels[var2] & '\uffff', 0);
         }

         return var1;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-89025185"
   )
   void method4544() {
      if(this.field3464 == -1) {
         this.field3464 = 0;
         if(this.objectModels != null && (this.objectTypes == null || this.objectTypes[0] == 10)) {
            this.field3464 = 1;
         }

         for(int var1 = 0; var1 < 5; ++var1) {
            if(this.actions[var1] != null) {
               this.field3464 = 1;
            }
         }
      }

      if(this.field3482 == -1) {
         this.field3482 = this.field3459 != 0?1:0;
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-225466583"
   )
   @Export("loadData")
   void loadData(Buffer var1, int var2) {
      int var3;
      int var4;
      if(var2 == 1) {
         var3 = var1.readUnsignedByte();
         if(var3 > 0) {
            if(this.objectModels != null && !field3473) {
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
            if(this.objectModels != null && !field3473) {
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
         this.field3459 = 0;
         this.field3460 = false;
      } else if(var2 == 18) {
         this.field3460 = false;
      } else if(var2 == 19) {
         this.field3464 = var1.readUnsignedByte();
      } else if(var2 == 21) {
         this.field3447 = 0;
      } else if(var2 == 22) {
         this.nonFlatShading = true;
      } else if(var2 == 23) {
         this.clipped = true;
      } else if(var2 == 24) {
         this.animationId = var1.readUnsignedShort();
         if(this.animationId == '\uffff') {
            this.animationId = -1;
         }
      } else if(var2 == 27) {
         this.field3459 = 1;
      } else if(var2 == 28) {
         this.field3466 = var1.readUnsignedByte();
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
         this.field3456 = false;
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
         this.field3476 = true;
      } else if(var2 == 74) {
         this.isSolid = true;
      } else if(var2 == 75) {
         this.field3482 = var1.readUnsignedByte();
      } else if(var2 != 77 && var2 != 92) {
         if(var2 == 78) {
            this.ambientSoundId = var1.readUnsignedShort();
            this.field3487 = var1.readUnsignedByte();
         } else if(var2 == 79) {
            this.field3488 = var1.readUnsignedShort();
            this.field3489 = var1.readUnsignedShort();
            this.field3487 = var1.readUnsignedByte();
            var3 = var1.readUnsignedByte();
            this.field3479 = new int[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field3479[var4] = var1.readUnsignedShort();
            }
         } else if(var2 == 81) {
            this.field3447 = var1.readUnsignedByte() * 256;
         } else if(var2 == 82) {
            this.mapIconId = var1.readUnsignedShort();
         } else if(var2 == 249) {
            this.field3491 = ChatMessages.method1795(var1, this.field3491);
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

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II[[IIIILSequence;II)LModel;",
      garbageValue = "-755570531"
   )
   public final Model method4546(int var1, int var2, int[][] var3, int var4, int var5, int var6, Sequence var7, int var8) {
      long var9;
      if(this.objectTypes == null) {
         var9 = (long)((this.field3449 << 10) + var2);
      } else {
         var9 = (long)((this.field3449 << 10) + (var1 << 3) + var2);
      }

      Model var11 = (Model)field3452.get(var9);
      if(var11 == null) {
         ModelData var12 = this.method4547(var1, var2);
         if(var12 == null) {
            return null;
         }

         var11 = var12.light(this.ambient + 64, this.contrast + 768, -50, -10, -50);
         field3452.put(var11, var9);
      }

      if(var7 == null && this.field3447 == -1) {
         return var11;
      } else {
         if(var7 != null) {
            var11 = var7.method4719(var11, var8, var2);
         } else {
            var11 = var11.method2511(true);
         }

         if(this.field3447 >= 0) {
            var11 = var11.method2545(var3, var4, var5, var6, false, this.field3447);
         }

         return var11;
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(III)LModelData;",
      garbageValue = "-1991412052"
   )
   final ModelData method4547(int var1, int var2) {
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

         for(int var8 = 0; var8 < var5; ++var8) {
            var7 = this.objectModels[var8];
            if(var4) {
               var7 += 65536;
            }

            var3 = (ModelData)field3467.get((long)var7);
            if(var3 == null) {
               var3 = ModelData.method2416(field3443, var7 & '\uffff', 0);
               if(var3 == null) {
                  return null;
               }

               if(var4) {
                  var3.method2431();
               }

               field3467.put(var3, (long)var7);
            }

            if(var5 > 1) {
               field3461[var8] = var3;
            }
         }

         if(var5 > 1) {
            var3 = new ModelData(field3461, var5);
         }
      } else {
         int var9 = -1;

         for(var5 = 0; var5 < this.objectTypes.length; ++var5) {
            if(var1 == this.objectTypes[var5]) {
               var9 = var5;
               break;
            }
         }

         if(var9 == -1) {
            return null;
         }

         var5 = this.objectModels[var9];
         boolean var11 = this.isRotated ^ var2 > 3;
         if(var11) {
            var5 += 65536;
         }

         var3 = (ModelData)field3467.get((long)var5);
         if(var3 == null) {
            var3 = ModelData.method2416(field3443, var5 & '\uffff', 0);
            if(var3 == null) {
               return null;
            }

            if(var11) {
               var3.method2431();
            }

            field3467.put(var3, (long)var5);
         }
      }

      if(this.modelSizeX == 128 && this.modelSizeHeight == 128 && this.modelSizeY == 128) {
         var4 = false;
      } else {
         var4 = true;
      }

      boolean var10;
      if(this.offsetX == 0 && this.offsetHeight == 0 && this.offsetY == 0) {
         var10 = false;
      } else {
         var10 = true;
      }

      ModelData var6 = new ModelData(var3, var2 == 0 && !var4 && !var10, this.recolorToFind == null, this.textureToFind == null, true);
      if(var1 == 4 && var2 > 3) {
         var6.method2422(256);
         var6.method2428(45, 0, -45);
      }

      var2 &= 3;
      if(var2 == 1) {
         var6.method2425();
      } else if(var2 == 2) {
         var6.method2426();
      } else if(var2 == 3) {
         var6.method2415();
      }

      if(this.recolorToFind != null) {
         for(var7 = 0; var7 < this.recolorToFind.length; ++var7) {
            var6.method2490(this.recolorToFind[var7], this.recolorToReplace[var7]);
         }
      }

      if(this.textureToFind != null) {
         for(var7 = 0; var7 < this.textureToFind.length; ++var7) {
            var6.method2430(this.textureToFind[var7], this.textureToReplace[var7]);
         }
      }

      if(var4) {
         var6.method2432(this.modelSizeX, this.modelSizeHeight, this.modelSizeY);
      }

      if(var10) {
         var6.method2428(this.offsetX, this.offsetHeight, this.offsetY);
      }

      return var6;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)LObjectComposition;",
      garbageValue = "1809812125"
   )
   @Export("getImpostor")
   public final ObjectComposition getImpostor() {
      int var1 = -1;
      if(this.varpId != -1) {
         var1 = class205.method3843(this.varpId);
      } else if(this.configId != -1) {
         var1 = class211.widgetSettings[this.configId];
      }

      int var2;
      if(var1 >= 0 && var1 < this.impostorIds.length - 1) {
         var2 = this.impostorIds[var1];
      } else {
         var2 = this.impostorIds[this.impostorIds.length - 1];
      }

      return var2 != -1?class61.getObjectDefinition(var2):null;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1113411575"
   )
   public int method4549(int var1, int var2) {
      return class243.method4341(this.field3491, var1, var2);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "662446161"
   )
   public boolean method4551() {
      if(this.impostorIds == null) {
         return this.ambientSoundId != -1 || this.field3479 != null;
      } else {
         for(int var1 = 0; var1 < this.impostorIds.length; ++var1) {
            if(this.impostorIds[var1] != -1) {
               ObjectComposition var2 = class61.getObjectDefinition(this.impostorIds[var1]);
               if(var2.ambientSoundId != -1 || var2.field3479 != null) {
                  return true;
               }
            }
         }

         return false;
      }
   }

   static {
      field3473 = false;
      field3444 = new NodeCache(4096);
      field3467 = new NodeCache(500);
      field3446 = new NodeCache(30);
      field3452 = new NodeCache(30);
      field3461 = new ModelData[4];
   }

   ObjectComposition() {
      this.name = "null";
      this.sizeX = 1;
      this.sizeY = 1;
      this.field3459 = 2;
      this.field3460 = true;
      this.field3464 = -1;
      this.field3447 = -1;
      this.nonFlatShading = false;
      this.clipped = false;
      this.animationId = -1;
      this.field3466 = 16;
      this.ambient = 0;
      this.contrast = 0;
      this.actions = new String[5];
      this.mapIconId = -1;
      this.mapSceneId = -1;
      this.isRotated = false;
      this.field3456 = true;
      this.modelSizeX = 128;
      this.modelSizeHeight = 128;
      this.modelSizeY = 128;
      this.offsetX = 0;
      this.offsetHeight = 0;
      this.offsetY = 0;
      this.field3476 = false;
      this.isSolid = false;
      this.field3482 = -1;
      this.varpId = -1;
      this.configId = -1;
      this.ambientSoundId = -1;
      this.field3487 = 0;
      this.field3488 = 0;
      this.field3489 = 0;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;S)Ljava/lang/String;",
      garbageValue = "2554"
   )
   public String method4555(int var1, String var2) {
      return class204.method3838(this.field3491, var1, var2);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II[[IIIIB)LModel;",
      garbageValue = "-48"
   )
   public final Model method4560(int var1, int var2, int[][] var3, int var4, int var5, int var6) {
      long var7;
      if(this.objectTypes == null) {
         var7 = (long)(var2 + (this.field3449 << 10));
      } else {
         var7 = (long)((this.field3449 << 10) + (var1 << 3) + var2);
      }

      Model var9 = (Model)field3452.get(var7);
      if(var9 == null) {
         ModelData var10 = this.method4547(var1, var2);
         if(var10 == null) {
            return null;
         }

         var9 = var10.light(this.ambient + 64, this.contrast + 768, -50, -10, -50);
         field3452.put(var9, var7);
      }

      if(this.field3447 >= 0) {
         var9 = var9.method2545(var3, var4, var5, var6, true, this.field3447);
      }

      return var9;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(II[[IIIIB)LRenderable;",
      garbageValue = "71"
   )
   public final Renderable method4562(int var1, int var2, int[][] var3, int var4, int var5, int var6) {
      long var7;
      if(this.objectTypes == null) {
         var7 = (long)((this.field3449 << 10) + var2);
      } else {
         var7 = (long)((this.field3449 << 10) + (var1 << 3) + var2);
      }

      Object var9 = (Renderable)field3446.get(var7);
      if(var9 == null) {
         ModelData var10 = this.method4547(var1, var2);
         if(var10 == null) {
            return null;
         }

         if(!this.nonFlatShading) {
            var9 = var10.light(this.ambient + 64, this.contrast + 768, -50, -10, -50);
         } else {
            var10.field1802 = (short)(this.ambient + 64);
            var10.field1835 = (short)(this.contrast + 768);
            var10.computeNormals();
            var9 = var10;
         }

         field3446.put((CacheableNode)var9, var7);
      }

      if(this.nonFlatShading) {
         var9 = ((ModelData)var9).method2433();
      }

      if(this.field3447 >= 0) {
         if(var9 instanceof Model) {
            var9 = ((Model)var9).method2545(var3, var4, var5, var6, true, this.field3447);
         } else if(var9 instanceof ModelData) {
            var9 = ((ModelData)var9).method2421(var3, var4, var5, var6, true, this.field3447);
         }
      }

      return (Renderable)var9;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "958781655"
   )
   static void method4582(int var0) {
      XItemContainer var1 = (XItemContainer)XItemContainer.itemContainers.method3545((long)var0);
      if(var1 != null) {
         for(int var2 = 0; var2 < var1.itemIds.length; ++var2) {
            var1.itemIds[var2] = -1;
            var1.stackSizes[var2] = 0;
         }

      }
   }
}
