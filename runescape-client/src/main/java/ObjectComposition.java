import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ij")
@Implements("ObjectComposition")
public class ObjectComposition extends CacheableNode {
   @ObfuscatedName("j")
   public static NodeCache field3441;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = -1932370703
   )
   public int field3442;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = -727185323
   )
   @Export("modelSizeX")
   int modelSizeX;
   @ObfuscatedName("m")
   public static IndexDataBase field3444;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1335384567
   )
   public int field3445;
   @ObfuscatedName("z")
   public static NodeCache field3446;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = 587067797
   )
   @Export("modelSizeY")
   int modelSizeY;
   @ObfuscatedName("i")
   static ModelData[] field3448;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = 72816889
   )
   @Export("ambient")
   int ambient;
   @ObfuscatedName("c")
   @Export("objectModels")
   int[] objectModels;
   @ObfuscatedName("o")
   @Export("objectTypes")
   int[] objectTypes;
   @ObfuscatedName("q")
   @Export("name")
   public String name;
   @ObfuscatedName("w")
   public static NodeCache field3453;
   @ObfuscatedName("a")
   @Export("recolorToReplace")
   short[] recolorToReplace;
   @ObfuscatedName("g")
   @Export("textureToFind")
   short[] textureToFind;
   @ObfuscatedName("v")
   @Export("textureToReplace")
   short[] textureToReplace;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -293654233
   )
   @Export("sizeX")
   public int sizeX;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1340603343
   )
   @Export("sizeY")
   public int sizeY;
   @ObfuscatedName("e")
   public static IndexDataBase field3459;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = -707788571
   )
   @Export("modelSizeHeight")
   int modelSizeHeight;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1681178727
   )
   public int field3461;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1723417581
   )
   int field3462;
   @ObfuscatedName("x")
   @Export("nonFlatShading")
   boolean nonFlatShading;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = 1915092951
   )
   @Export("contrast")
   int contrast;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 250120873
   )
   @Export("animationId")
   public int animationId;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = 8269621
   )
   public int field3466;
   @ObfuscatedName("p")
   public static boolean field3467;
   @ObfuscatedName("l")
   public boolean field3468;
   @ObfuscatedName("af")
   @Export("actions")
   public String[] actions;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 2147356211
   )
   @Export("mapIconId")
   public int mapIconId;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = 406986691
   )
   @Export("mapSceneId")
   public int mapSceneId;
   @ObfuscatedName("ak")
   @Export("isRotated")
   boolean isRotated;
   @ObfuscatedName("al")
   public boolean field3473;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = 656141571
   )
   @Export("ambientSoundId")
   public int ambientSoundId;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1696097223
   )
   public int field3475;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -695689285
   )
   public int field3476;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -772149853
   )
   @Export("offsetX")
   int offsetX;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = 849703279
   )
   @Export("offsetHeight")
   int offsetHeight;
   @ObfuscatedName("b")
   @Export("clipped")
   public boolean clipped;
   @ObfuscatedName("ay")
   public boolean field3480;
   @ObfuscatedName("aj")
   @Export("isSolid")
   boolean isSolid;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = 1096025381
   )
   public int field3482;
   @ObfuscatedName("aq")
   @Export("impostorIds")
   public int[] impostorIds;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = -189871223
   )
   @Export("varpId")
   int varpId;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = 1829678185
   )
   @Export("offsetY")
   int offsetY;
   @ObfuscatedName("n")
   @Export("recolorToFind")
   short[] recolorToFind;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = 1604078207
   )
   @Export("configId")
   int configId;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = 332136149
   )
   public int field3488;
   @ObfuscatedName("t")
   public static NodeCache field3489;
   @ObfuscatedName("ah")
   public int[] field3490;
   @ObfuscatedName("ad")
   class186 field3491;

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-712440585"
   )
   public boolean method4387() {
      if(this.impostorIds == null) {
         return this.ambientSoundId != -1 || this.field3490 != null;
      } else {
         for(int var1 = 0; var1 < this.impostorIds.length; ++var1) {
            if(this.impostorIds[var1] != -1) {
               ObjectComposition var2 = class29.getObjectDefinition(this.impostorIds[var1]);
               if(var2.ambientSoundId != -1 || var2.field3490 != null) {
                  return true;
               }
            }
         }

         return false;
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   void method4388() {
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

      if(this.field3482 == -1) {
         this.field3482 = this.field3476 != 0?1:0;
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "102245812"
   )
   void method4389(Buffer var1) {
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
      signature = "(II[[IIIIB)LRenderable;",
      garbageValue = "16"
   )
   public final Renderable method4393(int var1, int var2, int[][] var3, int var4, int var5, int var6) {
      long var7;
      if(this.objectTypes == null) {
         var7 = (long)((this.field3461 << 10) + var2);
      } else {
         var7 = (long)((var1 << 3) + (this.field3461 << 10) + var2);
      }

      Object var9 = (Renderable)field3446.get(var7);
      if(var9 == null) {
         ModelData var10 = this.method4396(var1, var2);
         if(var10 == null) {
            return null;
         }

         if(!this.nonFlatShading) {
            var9 = var10.light(this.ambient + 64, this.contrast + 768, -50, -10, -50);
         } else {
            var10.field1819 = (short)(this.ambient + 64);
            var10.field1829 = (short)(this.contrast + 768);
            var10.computeNormals();
            var9 = var10;
         }

         field3446.put((CacheableNode)var9, var7);
      }

      if(this.nonFlatShading) {
         var9 = ((ModelData)var9).method2314();
      }

      if(this.field3462 >= 0) {
         if(var9 instanceof Model) {
            var9 = ((Model)var9).method2392(var3, var4, var5, var6, true, this.field3462);
         } else if(var9 instanceof ModelData) {
            var9 = ((ModelData)var9).method2330(var3, var4, var5, var6, true, this.field3462);
         }
      }

      return (Renderable)var9;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II[[IIIII)LModel;",
      garbageValue = "764905869"
   )
   public final Model method4394(int var1, int var2, int[][] var3, int var4, int var5, int var6) {
      long var7;
      if(this.objectTypes == null) {
         var7 = (long)((this.field3461 << 10) + var2);
      } else {
         var7 = (long)((var1 << 3) + (this.field3461 << 10) + var2);
      }

      Model var9 = (Model)field3441.get(var7);
      if(var9 == null) {
         ModelData var10 = this.method4396(var1, var2);
         if(var10 == null) {
            return null;
         }

         var9 = var10.light(this.ambient + 64, this.contrast + 768, -50, -10, -50);
         field3441.put(var9, var7);
      }

      if(this.field3462 >= 0) {
         var9 = var9.method2392(var3, var4, var5, var6, true, this.field3462);
      }

      return var9;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(II[[IIIILSequence;IB)LModel;",
      garbageValue = "-44"
   )
   public final Model method4395(int var1, int var2, int[][] var3, int var4, int var5, int var6, Sequence var7, int var8) {
      long var9;
      if(this.objectTypes == null) {
         var9 = (long)((this.field3461 << 10) + var2);
      } else {
         var9 = (long)((var1 << 3) + (this.field3461 << 10) + var2);
      }

      Model var11 = (Model)field3441.get(var9);
      if(var11 == null) {
         ModelData var12 = this.method4396(var1, var2);
         if(var12 == null) {
            return null;
         }

         var11 = var12.light(this.ambient + 64, this.contrast + 768, -50, -10, -50);
         field3441.put(var11, var9);
      }

      if(var7 == null && this.field3462 == -1) {
         return var11;
      } else {
         if(var7 != null) {
            var11 = var7.method4586(var11, var8, var2);
         } else {
            var11 = var11.method2393(true);
         }

         if(this.field3462 >= 0) {
            var11 = var11.method2392(var3, var4, var5, var6, false, this.field3462);
         }

         return var11;
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIB)LModelData;",
      garbageValue = "35"
   )
   final ModelData method4396(int var1, int var2) {
      ModelData var3 = null;
      boolean var4;
      int var5;
      int var6;
      int var7;
      boolean var8;
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

         for(var7 = 0; var7 < var5; ++var7) {
            var6 = this.objectModels[var7];
            if(var4) {
               var6 += 65536;
            }

            var3 = (ModelData)field3453.get((long)var6);
            if(var3 == null) {
               var3 = ModelData.method2310(field3459, var6 & '\uffff', 0);
               if(var3 == null) {
                  return null;
               }

               if(var4) {
                  var3.method2371();
               }

               field3453.put(var3, (long)var6);
            }

            if(var5 > 1) {
               field3448[var7] = var3;
            }
         }

         if(var5 > 1) {
            var3 = new ModelData(field3448, var5);
         }
      } else {
         var7 = -1;

         for(var5 = 0; var5 < this.objectTypes.length; ++var5) {
            if(this.objectTypes[var5] == var1) {
               var7 = var5;
               break;
            }
         }

         if(var7 == -1) {
            return null;
         }

         var5 = this.objectModels[var7];
         var8 = this.isRotated ^ var2 > 3;
         if(var8) {
            var5 += 65536;
         }

         var3 = (ModelData)field3453.get((long)var5);
         if(var3 == null) {
            var3 = ModelData.method2310(field3459, var5 & '\uffff', 0);
            if(var3 == null) {
               return null;
            }

            if(var8) {
               var3.method2371();
            }

            field3453.put(var3, (long)var5);
         }
      }

      if(this.modelSizeX == 128 && this.modelSizeHeight == 128 && this.modelSizeY == 128) {
         var4 = false;
      } else {
         var4 = true;
      }

      if(this.offsetX == 0 && this.offsetHeight == 0 && this.offsetY == 0) {
         var8 = false;
      } else {
         var8 = true;
      }

      ModelData var9 = new ModelData(var3, var2 == 0 && !var4 && !var8, this.recolorToFind == null, this.textureToFind == null, true);
      if(var1 == 4 && var2 > 3) {
         var9.method2329(256);
         var9.method2359(45, 0, -45);
      }

      var2 &= 3;
      if(var2 == 1) {
         var9.method2358();
      } else if(var2 == 2) {
         var9.method2316();
      } else if(var2 == 3) {
         var9.method2319();
      }

      if(this.recolorToFind != null) {
         for(var6 = 0; var6 < this.recolorToFind.length; ++var6) {
            var9.method2322(this.recolorToFind[var6], this.recolorToReplace[var6]);
         }
      }

      if(this.textureToFind != null) {
         for(var6 = 0; var6 < this.textureToFind.length; ++var6) {
            var9.method2320(this.textureToFind[var6], this.textureToReplace[var6]);
         }
      }

      if(var4) {
         var9.method2325(this.modelSizeX, this.modelSizeHeight, this.modelSizeY);
      }

      if(var8) {
         var9.method2359(this.offsetX, this.offsetHeight, this.offsetY);
      }

      return var9;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)Ljava/lang/String;",
      garbageValue = "1144863483"
   )
   public String method4399(int var1, String var2) {
      return class165.method2965(this.field3491, var1, var2);
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-816550088"
   )
   @Export("loadData")
   void loadData(Buffer var1, int var2) {
      int var3;
      int var4;
      if(var2 == 1) {
         var3 = var1.readUnsignedByte();
         if(var3 > 0) {
            if(this.objectModels != null && !field3467) {
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
            if(this.objectModels != null && !field3467) {
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
         this.field3476 = 0;
         this.field3468 = false;
      } else if(var2 == 18) {
         this.field3468 = false;
      } else if(var2 == 19) {
         this.field3445 = var1.readUnsignedByte();
      } else if(var2 == 21) {
         this.field3462 = 0;
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
         this.field3476 = 1;
      } else if(var2 == 28) {
         this.field3475 = var1.readUnsignedByte();
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
         this.field3473 = false;
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
         this.field3480 = true;
      } else if(var2 == 74) {
         this.isSolid = true;
      } else if(var2 == 75) {
         this.field3482 = var1.readUnsignedByte();
      } else if(var2 != 77 && var2 != 92) {
         if(var2 == 78) {
            this.ambientSoundId = var1.readUnsignedShort();
            this.field3466 = var1.readUnsignedByte();
         } else if(var2 == 79) {
            this.field3488 = var1.readUnsignedShort();
            this.field3442 = var1.readUnsignedShort();
            this.field3466 = var1.readUnsignedByte();
            var3 = var1.readUnsignedByte();
            this.field3490 = new int[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field3490[var4] = var1.readUnsignedShort();
            }
         } else if(var2 == 81) {
            this.field3462 = var1.readUnsignedByte() * 256;
         } else if(var2 == 82) {
            this.mapIconId = var1.readUnsignedShort();
         } else if(var2 == 249) {
            this.field3491 = class172.method3016(var1, this.field3491);
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

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1434873756"
   )
   static final boolean method4411() {
      return class134.field2006;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1044899598"
   )
   public int method4414(int var1, int var2) {
      return Script.method1758(this.field3491, var1, var2);
   }

   ObjectComposition() {
      this.name = "null";
      this.sizeX = 1;
      this.sizeY = 1;
      this.field3476 = 2;
      this.field3468 = true;
      this.field3445 = -1;
      this.field3462 = -1;
      this.nonFlatShading = false;
      this.clipped = false;
      this.animationId = -1;
      this.field3475 = 16;
      this.ambient = 0;
      this.contrast = 0;
      this.actions = new String[5];
      this.mapIconId = -1;
      this.mapSceneId = -1;
      this.isRotated = false;
      this.field3473 = true;
      this.modelSizeX = 128;
      this.modelSizeHeight = 128;
      this.modelSizeY = 128;
      this.offsetX = 0;
      this.offsetHeight = 0;
      this.offsetY = 0;
      this.field3480 = false;
      this.isSolid = false;
      this.field3482 = -1;
      this.varpId = -1;
      this.configId = -1;
      this.ambientSoundId = -1;
      this.field3466 = 0;
      this.field3488 = 0;
      this.field3442 = 0;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(B)LObjectComposition;",
      garbageValue = "108"
   )
   @Export("getImpostor")
   public final ObjectComposition getImpostor() {
      int var1 = -1;
      if(this.varpId != -1) {
         var1 = class50.method728(this.varpId);
      } else if(this.configId != -1) {
         var1 = class211.widgetSettings[this.configId];
      }

      int var2;
      if(var1 >= 0 && var1 < this.impostorIds.length - 1) {
         var2 = this.impostorIds[var1];
      } else {
         var2 = this.impostorIds[this.impostorIds.length - 1];
      }

      return var2 != -1?class29.getObjectDefinition(var2):null;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-306843781"
   )
   public final boolean method4426(int var1) {
      if(this.objectTypes != null) {
         for(int var4 = 0; var4 < this.objectTypes.length; ++var4) {
            if(this.objectTypes[var4] == var1) {
               return field3459.method3997(this.objectModels[var4] & '\uffff', 0);
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
            var2 &= field3459.method3997(this.objectModels[var3] & '\uffff', 0);
         }

         return var2;
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-273533297"
   )
   public final boolean method4429() {
      if(this.objectModels == null) {
         return true;
      } else {
         boolean var1 = true;

         for(int var2 = 0; var2 < this.objectModels.length; ++var2) {
            var1 &= field3459.method3997(this.objectModels[var2] & '\uffff', 0);
         }

         return var1;
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lclass289;B)I",
      garbageValue = "-53"
   )
   static final int method4435(class289 var0) {
      if(var0 == null) {
         return 12;
      } else {
         switch(var0.field3859) {
         case 7:
            return 20;
         default:
            return 12;
         }
      }
   }

   static {
      field3467 = false;
      field3489 = new NodeCache(4096);
      field3453 = new NodeCache(500);
      field3446 = new NodeCache(30);
      field3441 = new NodeCache(30);
      field3448 = new ModelData[4];
   }
}
