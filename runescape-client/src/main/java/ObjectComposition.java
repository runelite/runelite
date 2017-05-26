import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("if")
@Implements("ObjectComposition")
public class ObjectComposition extends CacheableNode {
   @ObfuscatedName("i")
   static boolean field3428;
   @ObfuscatedName("h")
   static IndexDataBase field3429;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1237361257
   )
   @Export("sizeY")
   public int sizeY;
   @ObfuscatedName("q")
   public static NodeCache field3431;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = -1017529611
   )
   @Export("ambientSoundId")
   public int ambientSoundId;
   @ObfuscatedName("v")
   public static NodeCache field3433;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = -138273463
   )
   @Export("contrast")
   int contrast;
   @ObfuscatedName("p")
   static ModelData[] field3435;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 494544567
   )
   public int field3436;
   @ObfuscatedName("a")
   @Export("objectModels")
   int[] objectModels;
   @ObfuscatedName("k")
   @Export("objectTypes")
   int[] objectTypes;
   @ObfuscatedName("r")
   @Export("name")
   public String name;
   @ObfuscatedName("b")
   @Export("recolorToFind")
   short[] recolorToFind;
   @ObfuscatedName("u")
   static IndexDataBase field3441;
   @ObfuscatedName("o")
   @Export("textureToFind")
   short[] textureToFind;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -1731666379
   )
   public int field3443;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1171588625
   )
   @Export("animationId")
   public int animationId;
   @ObfuscatedName("af")
   @Export("isRotated")
   boolean isRotated;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 2112266131
   )
   public int field3446;
   @ObfuscatedName("s")
   public boolean field3447;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 724797881
   )
   @Export("offsetX")
   int offsetX;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1863347845
   )
   int field3449;
   @ObfuscatedName("az")
   @Export("actions")
   public String[] actions;
   @ObfuscatedName("f")
   public boolean field3451;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 355765283
   )
   @Export("sizeX")
   public int sizeX;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -628552909
   )
   public int field3453;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = 711252731
   )
   @Export("ambient")
   int ambient;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = -334963393
   )
   @Export("offsetY")
   int offsetY;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 20862899
   )
   public int field3456;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = -421296471
   )
   @Export("mapIconId")
   public int mapIconId;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = 1804235583
   )
   @Export("mapSceneId")
   public int mapSceneId;
   @ObfuscatedName("an")
   public int[] field3459;
   @ObfuscatedName("aj")
   public boolean field3460;
   @ObfuscatedName("at")
   public boolean field3461;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -2032526287
   )
   @Export("modelSizeX")
   int modelSizeX;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = -2146325105
   )
   @Export("modelSizeY")
   int modelSizeY;
   @ObfuscatedName("t")
   public static NodeCache field3464;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = 886681849
   )
   @Export("offsetHeight")
   int offsetHeight;
   @ObfuscatedName("w")
   @Export("nonFlatShading")
   boolean nonFlatShading;
   @ObfuscatedName("au")
   class186 field3467;
   @ObfuscatedName("ai")
   @Export("isSolid")
   boolean isSolid;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = 1986749761
   )
   public int field3469;
   @ObfuscatedName("am")
   @Export("impostorIds")
   public int[] impostorIds;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = -2128894895
   )
   @Export("varpId")
   int varpId;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = 2094810015
   )
   @Export("configId")
   int configId;
   @ObfuscatedName("j")
   @Export("textureToReplace")
   short[] textureToReplace;
   @ObfuscatedName("al")
   public int field3474;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = 305269051
   )
   @Export("modelSizeHeight")
   int modelSizeHeight;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = 1639896785
   )
   public int field3476;
   @ObfuscatedName("x")
   @Export("recolorToReplace")
   short[] recolorToReplace;
   @ObfuscatedName("g")
   public static NodeCache field3478;

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1368012449"
   )
   void method4579() {
      if(this.field3456 == -1) {
         this.field3456 = 0;
         if(this.objectModels != null && (this.objectTypes == null || this.objectTypes[0] == 10)) {
            this.field3456 = 1;
         }

         for(int var1 = 0; var1 < 5; ++var1) {
            if(this.actions[var1] != null) {
               this.field3456 = 1;
            }
         }
      }

      if(this.field3443 == -1) {
         this.field3443 = this.field3446 != 0?1:0;
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "25575798"
   )
   void method4580(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.loadData(var1, var2);
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(LBuffer;IB)V",
      garbageValue = "68"
   )
   @Export("loadData")
   void loadData(Buffer var1, int var2) {
      int var3;
      int var4;
      if(var2 == 1) {
         var3 = var1.readUnsignedByte();
         if(var3 > 0) {
            if(this.objectModels != null && !field3428) {
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
            if(this.objectModels != null && !field3428) {
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
         this.field3446 = 0;
         this.field3447 = false;
      } else if(var2 == 18) {
         this.field3447 = false;
      } else if(var2 == 19) {
         this.field3456 = var1.readUnsignedByte();
      } else if(var2 == 21) {
         this.field3449 = 0;
      } else if(var2 == 22) {
         this.nonFlatShading = true;
      } else if(var2 == 23) {
         this.field3451 = true;
      } else if(var2 == 24) {
         this.animationId = var1.readUnsignedShort();
         if(this.animationId == '\uffff') {
            this.animationId = -1;
         }
      } else if(var2 == 27) {
         this.field3446 = 1;
      } else if(var2 == 28) {
         this.field3453 = var1.readUnsignedByte();
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
         this.field3460 = false;
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
         this.field3461 = true;
      } else if(var2 == 74) {
         this.isSolid = true;
      } else if(var2 == 75) {
         this.field3443 = var1.readUnsignedByte();
      } else if(var2 != 77 && var2 != 92) {
         if(var2 == 78) {
            this.ambientSoundId = var1.readUnsignedShort();
            this.field3474 = var1.readUnsignedByte() * -44729;
         } else if(var2 == 79) {
            this.field3469 = var1.readUnsignedShort();
            this.field3476 = var1.readUnsignedShort();
            this.field3474 = var1.readUnsignedByte() * -44729;
            var3 = var1.readUnsignedByte();
            this.field3459 = new int[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field3459[var4] = var1.readUnsignedShort();
            }
         } else if(var2 == 81) {
            this.field3449 = var1.readUnsignedByte() * 256;
         } else if(var2 == 82) {
            this.mapIconId = var1.readUnsignedShort();
         } else if(var2 == 249) {
            this.field3467 = Frames.method2913(var1, this.field3467);
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

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "433055153"
   )
   public final boolean method4583() {
      if(this.objectModels == null) {
         return true;
      } else {
         boolean var1 = true;

         for(int var2 = 0; var2 < this.objectModels.length; ++var2) {
            var1 &= field3441.method4176(this.objectModels[var2] & '\uffff', 0);
         }

         return var1;
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(II[[IIIII)LModel;",
      garbageValue = "-1834309861"
   )
   public final Model method4585(int var1, int var2, int[][] var3, int var4, int var5, int var6) {
      long var7;
      if(this.objectTypes == null) {
         var7 = (long)((this.field3436 << 10) + var2);
      } else {
         var7 = (long)((this.field3436 << 10) + (var1 << 3) + var2);
      }

      Model var9 = (Model)field3464.get(var7);
      if(var9 == null) {
         ModelData var10 = this.method4587(var1, var2);
         if(var10 == null) {
            return null;
         }

         var9 = var10.method2487(this.ambient + 64, this.contrast + 768, -50, -10, -50);
         field3464.put(var9, var7);
      }

      if(this.field3449 >= 0) {
         var9 = var9.method2534(var3, var4, var5, var6, true, this.field3449);
      }

      return var9;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(II[[IIIILSequence;II)LModel;",
      garbageValue = "-2131849"
   )
   public final Model method4586(int var1, int var2, int[][] var3, int var4, int var5, int var6, Sequence var7, int var8) {
      long var9;
      if(this.objectTypes == null) {
         var9 = (long)(var2 + (this.field3436 << 10));
      } else {
         var9 = (long)(var2 + (var1 << 3) + (this.field3436 << 10));
      }

      Model var11 = (Model)field3464.get(var9);
      if(var11 == null) {
         ModelData var12 = this.method4587(var1, var2);
         if(var12 == null) {
            return null;
         }

         var11 = var12.method2487(this.ambient + 64, this.contrast + 768, -50, -10, -50);
         field3464.put(var11, var9);
      }

      if(var7 == null && this.field3449 == -1) {
         return var11;
      } else {
         if(var7 != null) {
            var11 = var7.method4756(var11, var8, var2);
         } else {
            var11 = var11.method2535(true);
         }

         if(this.field3449 >= 0) {
            var11 = var11.method2534(var3, var4, var5, var6, false, this.field3449);
         }

         return var11;
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(III)LModelData;",
      garbageValue = "1783009051"
   )
   final ModelData method4587(int var1, int var2) {
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

            var3 = (ModelData)field3478.get((long)var7);
            if(var3 == null) {
               var3 = ModelData.method2443(field3441, var7 & '\uffff', 0);
               if(var3 == null) {
                  return null;
               }

               if(var4) {
                  var3.method2459();
               }

               field3478.put(var3, (long)var7);
            }

            if(var5 > 1) {
               field3435[var8] = var3;
            }
         }

         if(var5 > 1) {
            var3 = new ModelData(field3435, var5);
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
         boolean var11 = this.isRotated ^ var2 > 3;
         if(var11) {
            var5 += 65536;
         }

         var3 = (ModelData)field3478.get((long)var5);
         if(var3 == null) {
            var3 = ModelData.method2443(field3441, var5 & '\uffff', 0);
            if(var3 == null) {
               return null;
            }

            if(var11) {
               var3.method2459();
            }

            field3478.put(var3, (long)var5);
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

      ModelData var6 = new ModelData(var3, var2 == 0 && !var4 && !var10, null == this.recolorToFind, this.textureToFind == null, true);
      if(var1 == 4 && var2 > 3) {
         var6.method2455(256);
         var6.method2456(45, 0, -45);
      }

      var2 &= 3;
      if(var2 == 1) {
         var6.method2452();
      } else if(var2 == 2) {
         var6.method2482();
      } else if(var2 == 3) {
         var6.method2512();
      }

      if(this.recolorToFind != null) {
         for(var7 = 0; var7 < this.recolorToFind.length; ++var7) {
            var6.method2505(this.recolorToFind[var7], this.recolorToReplace[var7]);
         }
      }

      if(this.textureToFind != null) {
         for(var7 = 0; var7 < this.textureToFind.length; ++var7) {
            var6.method2511(this.textureToFind[var7], this.textureToReplace[var7]);
         }
      }

      if(var4) {
         var6.method2510(this.modelSizeX, this.modelSizeHeight, this.modelSizeY);
      }

      if(var10) {
         var6.method2456(this.offsetX, this.offsetHeight, this.offsetY);
      }

      return var6;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "824357379"
   )
   public int method4588(int var1, int var2) {
      return class169.method3168(this.field3467, var1, var2);
   }

   ObjectComposition() {
      this.name = "null";
      this.sizeX = 1;
      this.sizeY = 1;
      this.field3446 = 2;
      this.field3447 = true;
      this.field3456 = -1;
      this.field3449 = -1;
      this.nonFlatShading = false;
      this.field3451 = false;
      this.animationId = -1;
      this.field3453 = 16;
      this.ambient = 0;
      this.contrast = 0;
      this.actions = new String[5];
      this.mapIconId = -1;
      this.mapSceneId = -1;
      this.isRotated = false;
      this.field3460 = true;
      this.modelSizeX = 128;
      this.modelSizeHeight = 128;
      this.modelSizeY = 128;
      this.offsetX = 0;
      this.offsetHeight = 0;
      this.offsetY = 0;
      this.field3461 = false;
      this.isSolid = false;
      this.field3443 = -1;
      this.varpId = -1;
      this.configId = -1;
      this.ambientSoundId = -1;
      this.field3474 = 0;
      this.field3469 = 0;
      this.field3476 = 0;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "1"
   )
   public final boolean method4589(int var1) {
      if(this.objectTypes != null) {
         for(int var4 = 0; var4 < this.objectTypes.length; ++var4) {
            if(this.objectTypes[var4] == var1) {
               return field3441.method4176(this.objectModels[var4] & '\uffff', 0);
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
            var2 &= field3441.method4176(this.objectModels[var3] & '\uffff', 0);
         }

         return var2;
      }
   }

   static {
      field3428 = false;
      field3431 = new NodeCache(4096);
      field3478 = new NodeCache(500);
      field3433 = new NodeCache(30);
      field3464 = new NodeCache(30);
      field3435 = new ModelData[4];
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II[[IIIIB)LRenderable;",
      garbageValue = "-23"
   )
   public final Renderable method4603(int var1, int var2, int[][] var3, int var4, int var5, int var6) {
      long var7;
      if(this.objectTypes == null) {
         var7 = (long)(var2 + (this.field3436 << 10));
      } else {
         var7 = (long)(var2 + (this.field3436 << 10) + (var1 << 3));
      }

      Object var9 = (Renderable)field3433.get(var7);
      if(var9 == null) {
         ModelData var10 = this.method4587(var1, var2);
         if(var10 == null) {
            return null;
         }

         if(!this.nonFlatShading) {
            var9 = var10.method2487(this.ambient + 64, this.contrast + 768, -50, -10, -50);
         } else {
            var10.field1810 = (short)(this.ambient + 64);
            var10.field1782 = (short)(this.contrast + 768);
            var10.computeNormals();
            var9 = var10;
         }

         field3433.put((CacheableNode)var9, var7);
      }

      if(this.nonFlatShading) {
         var9 = ((ModelData)var9).method2449();
      }

      if(this.field3449 >= 0) {
         if(var9 instanceof Model) {
            var9 = ((Model)var9).method2534(var3, var4, var5, var6, true, this.field3449);
         } else if(var9 instanceof ModelData) {
            var9 = ((ModelData)var9).method2450(var3, var4, var5, var6, true, this.field3449);
         }
      }

      return (Renderable)var9;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(S)LObjectComposition;",
      garbageValue = "-8763"
   )
   @Export("getImpostor")
   public final ObjectComposition getImpostor() {
      int var1 = -1;
      if(this.varpId != -1) {
         var1 = Actor.method1539(this.varpId);
      } else if(this.configId != -1) {
         var1 = class211.widgetSettings[this.configId];
      }

      int var2;
      if(var1 >= 0 && var1 < this.impostorIds.length - 1) {
         var2 = this.impostorIds[var1];
      } else {
         var2 = this.impostorIds[this.impostorIds.length - 1];
      }

      return var2 != -1?class43.getObjectDefinition(var2):null;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;B)Ljava/lang/String;",
      garbageValue = "-12"
   )
   public String method4614(int var1, String var2) {
      return KitDefinition.method4451(this.field3467, var1, var2);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1707021354"
   )
   public boolean method4623() {
      if(this.impostorIds == null) {
         return this.ambientSoundId != -1 || this.field3459 != null;
      } else {
         for(int var1 = 0; var1 < this.impostorIds.length; ++var1) {
            if(this.impostorIds[var1] != -1) {
               ObjectComposition var2 = class43.getObjectDefinition(this.impostorIds[var1]);
               if(var2.ambientSoundId != -1 || var2.field3459 != null) {
                  return true;
               }
            }
         }

         return false;
      }
   }
}
