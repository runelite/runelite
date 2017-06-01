import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iu")
@Implements("ObjectComposition")
public class ObjectComposition extends CacheableNode {
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 531192507
   )
   int field3432;
   @ObfuscatedName("n")
   @Export("objectModels")
   int[] objectModels;
   @ObfuscatedName("x")
   static ModelData[] field3434;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -593829745
   )
   public int field3435;
   @ObfuscatedName("y")
   public static NodeCache field3436;
   @ObfuscatedName("l")
   public boolean field3437;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = 1549308819
   )
   @Export("ambient")
   int ambient;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 642834587
   )
   public int field3439;
   @ObfuscatedName("v")
   public static NodeCache field3440;
   @ObfuscatedName("a")
   @Export("objectTypes")
   int[] objectTypes;
   @ObfuscatedName("av")
   @Export("isSolid")
   boolean isSolid;
   @ObfuscatedName("z")
   @Export("recolorToFind")
   short[] recolorToFind;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1560225433
   )
   @Export("animationId")
   public int animationId;
   @ObfuscatedName("j")
   @Export("textureToFind")
   short[] textureToFind;
   @ObfuscatedName("k")
   @Export("textureToReplace")
   short[] textureToReplace;
   @ObfuscatedName("h")
   public static NodeCache field3447;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1709523073
   )
   @Export("sizeY")
   public int sizeY;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = -2058675789
   )
   @Export("offsetY")
   int offsetY;
   @ObfuscatedName("s")
   public boolean field3450;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 603505151
   )
   public int field3451;
   @ObfuscatedName("i")
   public static boolean field3452;
   @ObfuscatedName("p")
   @Export("nonFlatShading")
   boolean nonFlatShading;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = 1131944067
   )
   @Export("mapIconId")
   public int mapIconId;
   @ObfuscatedName("b")
   public static NodeCache field3455;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = 510206237
   )
   @Export("offsetHeight")
   int offsetHeight;
   @ObfuscatedName("ai")
   public boolean field3457;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = 903100271
   )
   @Export("contrast")
   int contrast;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = 1603321615
   )
   public int field3459;
   @ObfuscatedName("an")
   @Export("actions")
   public String[] actions;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = 590395327
   )
   @Export("mapSceneId")
   public int mapSceneId;
   @ObfuscatedName("ah")
   @Export("isRotated")
   boolean isRotated;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = 1821902743
   )
   @Export("offsetX")
   int offsetX;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = 1535639361
   )
   @Export("modelSizeX")
   int modelSizeX;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = -490303521
   )
   @Export("modelSizeHeight")
   int modelSizeHeight;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = -291993651
   )
   @Export("modelSizeY")
   int modelSizeY;
   @ObfuscatedName("c")
   public static IndexDataBase field3467;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1025709475
   )
   @Export("sizeX")
   public int sizeX;
   @ObfuscatedName("o")
   @Export("name")
   public String name;
   @ObfuscatedName("as")
   public boolean field3470;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1253923861
   )
   public int field3471;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = 1156667623
   )
   public int field3472;
   @ObfuscatedName("az")
   @Export("impostorIds")
   public int[] impostorIds;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = -1508637225
   )
   @Export("varpId")
   int varpId;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -656218329
   )
   @Export("configId")
   int configId;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = -1707496305
   )
   @Export("ambientSoundId")
   public int ambientSoundId;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = 1253540313
   )
   public int field3477;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = 295920811
   )
   public int field3478;
   @ObfuscatedName("q")
   @Export("recolorToReplace")
   short[] recolorToReplace;
   @ObfuscatedName("ak")
   public int[] field3480;
   @ObfuscatedName("ao")
   class186 field3481;

   ObjectComposition() {
      this.name = "null";
      this.sizeX = 1;
      this.sizeY = 1;
      this.field3471 = 2;
      this.field3450 = true;
      this.field3451 = -1;
      this.field3432 = -1;
      this.nonFlatShading = false;
      this.field3437 = false;
      this.animationId = -1;
      this.field3435 = 16;
      this.ambient = 0;
      this.contrast = 0;
      this.actions = new String[5];
      this.mapIconId = -1;
      this.mapSceneId = -1;
      this.isRotated = false;
      this.field3457 = true;
      this.modelSizeX = 128;
      this.modelSizeHeight = 128;
      this.modelSizeY = 128;
      this.offsetX = 0;
      this.offsetHeight = 0;
      this.offsetY = 0;
      this.field3470 = false;
      this.isSolid = false;
      this.field3472 = -1;
      this.varpId = -1;
      this.configId = -1;
      this.ambientSoundId = -1;
      this.field3477 = 0;
      this.field3478 = 0;
      this.field3459 = 0;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "2"
   )
   void method4526(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.loadData(var1, var2);
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "1782201925"
   )
   public final boolean method4528(int var1) {
      if(this.objectTypes != null) {
         for(int var4 = 0; var4 < this.objectTypes.length; ++var4) {
            if(this.objectTypes[var4] == var1) {
               return class249.field3377.method4111(this.objectModels[var4] & '\uffff', 0);
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
            var2 &= class249.field3377.method4111(this.objectModels[var3] & '\uffff', 0);
         }

         return var2;
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "1"
   )
   public final boolean method4529() {
      if(this.objectModels == null) {
         return true;
      } else {
         boolean var1 = true;

         for(int var2 = 0; var2 < this.objectModels.length; ++var2) {
            var1 &= class249.field3377.method4111(this.objectModels[var2] & '\uffff', 0);
         }

         return var1;
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II[[IIIII)LModel;",
      garbageValue = "-1997611876"
   )
   public final Model method4531(int var1, int var2, int[][] var3, int var4, int var5, int var6) {
      long var7;
      if(this.objectTypes == null) {
         var7 = (long)(var2 + (this.field3439 << 10));
      } else {
         var7 = (long)((var1 << 3) + (this.field3439 << 10) + var2);
      }

      Model var9 = (Model)field3447.get(var7);
      if(var9 == null) {
         ModelData var10 = this.method4533(var1, var2);
         if(var10 == null) {
            return null;
         }

         var9 = var10.method2417(this.ambient + 64, this.contrast + 768, -50, -10, -50);
         field3447.put(var9, var7);
      }

      if(this.field3432 >= 0) {
         var9 = var9.method2551(var3, var4, var5, var6, true, this.field3432);
      }

      return var9;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II[[IIIILSequence;II)LModel;",
      garbageValue = "1544511250"
   )
   public final Model method4532(int var1, int var2, int[][] var3, int var4, int var5, int var6, Sequence var7, int var8) {
      long var9;
      if(this.objectTypes == null) {
         var9 = (long)((this.field3439 << 10) + var2);
      } else {
         var9 = (long)(var2 + (var1 << 3) + (this.field3439 << 10));
      }

      Model var11 = (Model)field3447.get(var9);
      if(var11 == null) {
         ModelData var12 = this.method4533(var1, var2);
         if(var12 == null) {
            return null;
         }

         var11 = var12.method2417(this.ambient + 64, this.contrast + 768, -50, -10, -50);
         field3447.put(var11, var9);
      }

      if(var7 == null && this.field3432 == -1) {
         return var11;
      } else {
         if(var7 != null) {
            var11 = var7.method4690(var11, var8, var2);
         } else {
            var11 = var11.method2541(true);
         }

         if(this.field3432 >= 0) {
            var11 = var11.method2551(var3, var4, var5, var6, false, this.field3432);
         }

         return var11;
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(III)LModelData;",
      garbageValue = "-1225068943"
   )
   final ModelData method4533(int var1, int var2) {
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

            var3 = (ModelData)field3455.get((long)var7);
            if(var3 == null) {
               var3 = ModelData.method2427(class249.field3377, var7 & '\uffff', 0);
               if(var3 == null) {
                  return null;
               }

               if(var4) {
                  var3.method2411();
               }

               field3455.put(var3, (long)var7);
            }

            if(var5 > 1) {
               field3434[var6] = var3;
            }
         }

         if(var5 > 1) {
            var3 = new ModelData(field3434, var5);
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
         boolean var10 = this.isRotated ^ var2 > 3;
         if(var10) {
            var5 += 65536;
         }

         var3 = (ModelData)field3455.get((long)var5);
         if(var3 == null) {
            var3 = ModelData.method2427(class249.field3377, var5 & '\uffff', 0);
            if(var3 == null) {
               return null;
            }

            if(var10) {
               var3.method2411();
            }

            field3455.put(var3, (long)var5);
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
         var8.method2455(256);
         var8.method2408(45, 0, -45);
      }

      var2 &= 3;
      if(var2 == 1) {
         var8.method2404();
      } else if(var2 == 2) {
         var8.method2425();
      } else if(var2 == 3) {
         var8.method2407();
      }

      if(this.recolorToFind != null) {
         for(var7 = 0; var7 < this.recolorToFind.length; ++var7) {
            var8.method2409(this.recolorToFind[var7], this.recolorToReplace[var7]);
         }
      }

      if(this.textureToFind != null) {
         for(var7 = 0; var7 < this.textureToFind.length; ++var7) {
            var8.method2450(this.textureToFind[var7], this.textureToReplace[var7]);
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

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "-128"
   )
   public int method4535(int var1, int var2) {
      return World.method1583(this.field3481, var1, var2);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)Ljava/lang/String;",
      garbageValue = "1152855155"
   )
   public String method4536(int var1, String var2) {
      return class35.method480(this.field3481, var1, var2);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1844496964"
   )
   public boolean method4537() {
      if(this.impostorIds == null) {
         return this.ambientSoundId != -1 || this.field3480 != null;
      } else {
         for(int var1 = 0; var1 < this.impostorIds.length; ++var1) {
            if(this.impostorIds[var1] != -1) {
               ObjectComposition var2 = class226.getObjectDefinition(this.impostorIds[var1]);
               if(var2.ambientSoundId != -1 || var2.field3480 != null) {
                  return true;
               }
            }
         }

         return false;
      }
   }

   static {
      field3452 = false;
      field3440 = new NodeCache(4096);
      field3455 = new NodeCache(500);
      field3436 = new NodeCache(30);
      field3447 = new NodeCache(30);
      field3434 = new ModelData[4];
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II[[IIIIB)LRenderable;",
      garbageValue = "8"
   )
   public final Renderable method4547(int var1, int var2, int[][] var3, int var4, int var5, int var6) {
      long var7;
      if(this.objectTypes == null) {
         var7 = (long)(var2 + (this.field3439 << 10));
      } else {
         var7 = (long)(var2 + (this.field3439 << 10) + (var1 << 3));
      }

      Object var9 = (Renderable)field3436.get(var7);
      if(var9 == null) {
         ModelData var10 = this.method4533(var1, var2);
         if(var10 == null) {
            return null;
         }

         if(!this.nonFlatShading) {
            var9 = var10.method2417(this.ambient + 64, this.contrast + 768, -50, -10, -50);
         } else {
            var10.field1841 = (short)(this.ambient + 64);
            var10.field1844 = (short)(this.contrast + 768);
            var10.computeNormals();
            var9 = var10;
         }

         field3436.put((CacheableNode)var9, var7);
      }

      if(this.nonFlatShading) {
         var9 = ((ModelData)var9).method2401();
      }

      if(this.field3432 >= 0) {
         if(var9 instanceof Model) {
            var9 = ((Model)var9).method2551(var3, var4, var5, var6, true, this.field3432);
         } else if(var9 instanceof ModelData) {
            var9 = ((ModelData)var9).method2402(var3, var4, var5, var6, true, this.field3432);
         }
      }

      return (Renderable)var9;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "1946320288"
   )
   @Export("loadData")
   void loadData(Buffer var1, int var2) {
      int var3;
      int var4;
      if(var2 == 1) {
         var3 = var1.readUnsignedByte();
         if(var3 > 0) {
            if(this.objectModels != null && !field3452) {
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
            if(this.objectModels != null && !field3452) {
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
         this.field3471 = 0;
         this.field3450 = false;
      } else if(var2 == 18) {
         this.field3450 = false;
      } else if(var2 == 19) {
         this.field3451 = var1.readUnsignedByte();
      } else if(var2 == 21) {
         this.field3432 = 0;
      } else if(var2 == 22) {
         this.nonFlatShading = true;
      } else if(var2 == 23) {
         this.field3437 = true;
      } else if(var2 == 24) {
         this.animationId = var1.readUnsignedShort();
         if(this.animationId == '\uffff') {
            this.animationId = -1;
         }
      } else if(var2 == 27) {
         this.field3471 = 1;
      } else if(var2 == 28) {
         this.field3435 = var1.readUnsignedByte();
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
         this.field3457 = false;
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
         this.field3470 = true;
      } else if(var2 == 74) {
         this.isSolid = true;
      } else if(var2 == 75) {
         this.field3472 = var1.readUnsignedByte();
      } else if(var2 != 77 && var2 != 92) {
         if(var2 == 78) {
            this.ambientSoundId = var1.readUnsignedShort();
            this.field3477 = var1.readUnsignedByte();
         } else if(var2 == 79) {
            this.field3478 = var1.readUnsignedShort();
            this.field3459 = var1.readUnsignedShort();
            this.field3477 = var1.readUnsignedByte();
            var3 = var1.readUnsignedByte();
            this.field3480 = new int[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field3480[var4] = var1.readUnsignedShort();
            }
         } else if(var2 == 81) {
            this.field3432 = var1.readUnsignedByte() * 256;
         } else if(var2 == 82) {
            this.mapIconId = var1.readUnsignedShort();
         } else if(var2 == 249) {
            this.field3481 = class116.method2101(var1, this.field3481);
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

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(B)LObjectComposition;",
      garbageValue = "-1"
   )
   @Export("getImpostor")
   public final ObjectComposition getImpostor() {
      int var1 = -1;
      if(this.varpId != -1) {
         var1 = FileOnDisk.method2363(this.varpId);
      } else if(this.configId != -1) {
         var1 = class211.widgetSettings[this.configId];
      }

      int var2;
      if(var1 >= 0 && var1 < this.impostorIds.length - 1) {
         var2 = this.impostorIds[var1];
      } else {
         var2 = this.impostorIds[this.impostorIds.length - 1];
      }

      return var2 != -1?class226.getObjectDefinition(var2):null;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "58"
   )
   void method4563() {
      if(this.field3451 == -1) {
         this.field3451 = 0;
         if(this.objectModels != null && (this.objectTypes == null || this.objectTypes[0] == 10)) {
            this.field3451 = 1;
         }

         for(int var1 = 0; var1 < 5; ++var1) {
            if(this.actions[var1] != null) {
               this.field3451 = 1;
            }
         }
      }

      if(this.field3472 == -1) {
         this.field3472 = this.field3471 != 0?1:0;
      }

   }
}
