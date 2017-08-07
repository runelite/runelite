import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ia")
@Implements("ObjectComposition")
public class ObjectComposition extends CacheableNode {
   @ObfuscatedName("e")
   public static boolean field3452;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lgq;"
   )
   @Export("objects")
   public static NodeCache objects;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lit;"
   )
   public static IndexDataBase field3461;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lgq;"
   )
   public static NodeCache field3466;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lgq;"
   )
   @Export("cachedModels")
   public static NodeCache cachedModels;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lgq;"
   )
   public static NodeCache field3437;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "[Ldn;"
   )
   static ModelData[] field3432;
   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "Lgw;"
   )
   IterableHashTable field3445;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = 1673946903
   )
   @Export("varpId")
   int varpId;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1646627479
   )
   public int field3435;
   @ObfuscatedName("u")
   @Export("objectModels")
   int[] objectModels;
   @ObfuscatedName("d")
   @Export("objectTypes")
   int[] objectTypes;
   @ObfuscatedName("am")
   @Export("impostorIds")
   public int[] impostorIds;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = -255815549
   )
   @Export("ambientSoundId")
   public int ambientSoundId;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = -1894753801
   )
   public int field3451;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = -1234655989
   )
   @Export("configId")
   int configId;
   @ObfuscatedName("o")
   @Export("name")
   public String name;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1169279107
   )
   @Export("id")
   public int id;
   @ObfuscatedName("ar")
   public int[] field3474;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = -483014441
   )
   @Export("mapIconId")
   public int mapIconId;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -582471371
   )
   @Export("sizeX")
   public int sizeX;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 191172481
   )
   @Export("interactType")
   public int interactType;
   @ObfuscatedName("al")
   @Export("isRotated")
   boolean isRotated;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1638049697
   )
   @Export("sizeY")
   public int sizeY;
   @ObfuscatedName("p")
   public boolean field3433;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = 708859353
   )
   public int field3457;
   @ObfuscatedName("x")
   @Export("nonFlatShading")
   boolean nonFlatShading;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -756910245
   )
   @Export("clipType")
   int clipType;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = -645562619
   )
   public int field3472;
   @ObfuscatedName("i")
   @Export("modelClipped")
   public boolean modelClipped;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = 1448777007
   )
   @Export("ambient")
   int ambient;
   @ObfuscatedName("au")
   @Export("actions")
   public String[] actions;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = -452964741
   )
   @Export("contrast")
   int contrast;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = -335882633
   )
   public int field3473;
   @ObfuscatedName("at")
   @Export("isSolid")
   boolean isSolid;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1904480601
   )
   @Export("animationId")
   public int animationId;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -1056904393
   )
   @Export("modelSizeX")
   int modelSizeX;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1235589425
   )
   public int field3429;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = -956995037
   )
   @Export("modelSizeHeight")
   int modelSizeHeight;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = -1280178297
   )
   @Export("modelSizeY")
   int modelSizeY;
   @ObfuscatedName("l")
   @Export("recolorToFind")
   short[] recolorToFind;
   @ObfuscatedName("ae")
   @Export("clipped")
   public boolean clipped;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = 329161593
   )
   @Export("mapSceneId")
   public int mapSceneId;
   @ObfuscatedName("s")
   @Export("textureToFind")
   short[] textureToFind;
   @ObfuscatedName("h")
   @Export("recolorToReplace")
   short[] recolorToReplace;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = 764959369
   )
   @Export("offsetX")
   int offsetX;
   @ObfuscatedName("c")
   @Export("textureToReplace")
   short[] textureToReplace;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = -359694185
   )
   @Export("offsetHeight")
   int offsetHeight;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = -339423875
   )
   @Export("offsetY")
   int offsetY;
   @ObfuscatedName("ad")
   public boolean field3464;

   static {
      field3452 = false;
      objects = new NodeCache(4096);
      field3437 = new NodeCache(500);
      cachedModels = new NodeCache(30);
      field3466 = new NodeCache(30);
      field3432 = new ModelData[4];
   }

   ObjectComposition() {
      this.name = "null";
      this.sizeX = 1;
      this.sizeY = 1;
      this.interactType = 2;
      this.field3433 = true;
      this.field3435 = -1;
      this.clipType = -1;
      this.nonFlatShading = false;
      this.modelClipped = false;
      this.animationId = -1;
      this.field3429 = 16;
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
      this.field3464 = false;
      this.isSolid = false;
      this.field3451 = -1;
      this.varpId = -1;
      this.configId = -1;
      this.ambientSoundId = -1;
      this.field3457 = 0;
      this.field3472 = 0;
      this.field3473 = 0;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)Lia;",
      garbageValue = "-123"
   )
   @Export("getImpostor")
   public final ObjectComposition getImpostor() {
      int var1 = -1;
      if(this.varpId != -1) {
         var1 = class209.method3887(this.varpId);
      } else if(this.configId != -1) {
         var1 = class212.widgetSettings[this.configId];
      }

      int var2;
      if(var1 >= 0 && var1 < this.impostorIds.length - 1) {
         var2 = this.impostorIds[var1];
      } else {
         var2 = this.impostorIds[this.impostorIds.length - 1];
      }

      return var2 != -1?WorldMapType1.getObjectDefinition(var2):null;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Lfh;II)V",
      garbageValue = "1682865905"
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
         this.interactType = 0;
         this.field3433 = false;
      } else if(var2 == 18) {
         this.field3433 = false;
      } else if(var2 == 19) {
         this.field3435 = var1.readUnsignedByte();
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
         this.field3429 = var1.readUnsignedByte();
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
         this.field3464 = true;
      } else if(var2 == 74) {
         this.isSolid = true;
      } else if(var2 == 75) {
         this.field3451 = var1.readUnsignedByte();
      } else if(var2 != 77 && var2 != 92) {
         if(var2 == 78) {
            this.ambientSoundId = var1.readUnsignedShort();
            this.field3457 = var1.readUnsignedByte();
         } else if(var2 == 79) {
            this.field3472 = var1.readUnsignedShort();
            this.field3473 = var1.readUnsignedShort();
            this.field3457 = var1.readUnsignedByte();
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
            this.field3445 = XItemContainer.method1083(var1, this.field3445);
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

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(III)Ldn;",
      garbageValue = "1440493603"
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
               var3 = ModelData.method2434(field3461, var7 & '\uffff', 0);
               if(var3 == null) {
                  return null;
               }

               if(var4) {
                  var3.method2463();
               }

               field3437.put(var3, (long)var7);
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

         var3 = (ModelData)field3437.get((long)var5);
         if(var3 == null) {
            var3 = ModelData.method2434(field3461, var5 & '\uffff', 0);
            if(var3 == null) {
               return null;
            }

            if(var10) {
               var3.method2463();
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
         var8.method2431(256);
         var8.method2421(45, 0, -45);
      }

      var2 &= 3;
      if(var2 == 1) {
         var8.method2428();
      } else if(var2 == 2) {
         var8.method2458();
      } else if(var2 == 3) {
         var8.method2430();
      }

      if(this.recolorToFind != null) {
         for(var7 = 0; var7 < this.recolorToFind.length; ++var7) {
            var8.recolor(this.recolorToFind[var7], this.recolorToReplace[var7]);
         }
      }

      if(this.textureToFind != null) {
         for(var7 = 0; var7 < this.textureToFind.length; ++var7) {
            var8.method2447(this.textureToFind[var7], this.textureToReplace[var7]);
         }
      }

      if(var4) {
         var8.method2436(this.modelSizeX, this.modelSizeHeight, this.modelSizeY);
      }

      if(var11) {
         var8.method2421(this.offsetX, this.offsetHeight, this.offsetY);
      }

      return var8;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "165"
   )
   @Export("post")
   void post() {
      if(this.field3435 == -1) {
         this.field3435 = 0;
         if(this.objectModels != null && (this.objectTypes == null || this.objectTypes[0] == 10)) {
            this.field3435 = 1;
         }

         for(int var1 = 0; var1 < 5; ++var1) {
            if(this.actions[var1] != null) {
               this.field3435 = 1;
            }
         }
      }

      if(this.field3451 == -1) {
         this.field3451 = this.interactType != 0?1:0;
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lfh;B)V",
      garbageValue = "49"
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

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(II[[IIIILjd;IS)Lew;",
      garbageValue = "-32133"
   )
   public final Model method4540(int var1, int var2, int[][] var3, int var4, int var5, int var6, Sequence var7, int var8) {
      long var9;
      if(this.objectTypes == null) {
         var9 = (long)(var2 + (this.id << 10));
      } else {
         var9 = (long)(var2 + (var1 << 3) + (this.id << 10));
      }

      Model var11 = (Model)field3466.get(var9);
      if(var11 == null) {
         ModelData var12 = this.getModel(var1, var2);
         if(var12 == null) {
            return null;
         }

         var11 = var12.light(this.ambient + 64, this.contrast + 768, -50, -10, -50);
         field3466.put(var11, var9);
      }

      if(var7 == null && this.clipType == -1) {
         return var11;
      } else {
         if(var7 != null) {
            var11 = var7.method4740(var11, var8, var2);
         } else {
            var11 = var11.method2608(true);
         }

         if(this.clipType >= 0) {
            var11 = var11.method2545(var3, var4, var5, var6, false, this.clipType);
         }

         return var11;
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-55"
   )
   public final boolean method4578() {
      if(this.objectModels == null) {
         return true;
      } else {
         boolean var1 = true;

         for(int var2 = 0; var2 < this.objectModels.length; ++var2) {
            var1 &= field3461.method4116(this.objectModels[var2] & '\uffff', 0);
         }

         return var1;
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "724494890"
   )
   public final boolean method4536(int var1) {
      if(this.objectTypes != null) {
         for(int var4 = 0; var4 < this.objectTypes.length; ++var4) {
            if(this.objectTypes[var4] == var1) {
               return field3461.method4116(this.objectModels[var4] & '\uffff', 0);
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
            var2 &= field3461.method4116(this.objectModels[var3] & '\uffff', 0);
         }

         return var2;
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1148655225"
   )
   public boolean method4545() {
      if(this.impostorIds == null) {
         return this.ambientSoundId != -1 || this.field3474 != null;
      } else {
         for(int var1 = 0; var1 < this.impostorIds.length; ++var1) {
            if(this.impostorIds[var1] != -1) {
               ObjectComposition var2 = WorldMapType1.getObjectDefinition(this.impostorIds[var1]);
               if(var2.ambientSoundId != -1 || var2.field3474 != null) {
                  return true;
               }
            }
         }

         return false;
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(II[[IIIIB)Lew;",
      garbageValue = "1"
   )
   public final Model method4539(int var1, int var2, int[][] var3, int var4, int var5, int var6) {
      long var7;
      if(this.objectTypes == null) {
         var7 = (long)(var2 + (this.id << 10));
      } else {
         var7 = (long)(var2 + (var1 << 3) + (this.id << 10));
      }

      Model var9 = (Model)field3466.get(var7);
      if(var9 == null) {
         ModelData var10 = this.getModel(var1, var2);
         if(var10 == null) {
            return null;
         }

         var9 = var10.light(this.ambient + 64, this.contrast + 768, -50, -10, -50);
         field3466.put(var9, var7);
      }

      if(this.clipType >= 0) {
         var9 = var9.method2545(var3, var4, var5, var6, true, this.clipType);
      }

      return var9;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(II[[IIIII)Leg;",
      garbageValue = "21055229"
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
            var10.field1814 = (short)(this.ambient + 64);
            var10.contrast = (short)(this.contrast + 768);
            var10.computeNormals();
            var9 = var10;
         }

         cachedModels.put((CacheableNode)var9, var7);
      }

      if(this.nonFlatShading) {
         var9 = ((ModelData)var9).method2425();
      }

      if(this.clipType >= 0) {
         if(var9 instanceof Model) {
            var9 = ((Model)var9).method2545(var3, var4, var5, var6, true, this.clipType);
         } else if(var9 instanceof ModelData) {
            var9 = ((ModelData)var9).method2426(var3, var4, var5, var6, true, this.clipType);
         }
      }

      return (Renderable)var9;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)Ljava/lang/String;",
      garbageValue = "-1533480400"
   )
   public String method4532(int var1, String var2) {
      return class169.method3148(this.field3445, var1, var2);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1291398140"
   )
   public int method4543(int var1, int var2) {
      return class34.method494(this.field3445, var1, var2);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)[Ljg;",
      garbageValue = "98165065"
   )
   static class277[] method4549() {
      return new class277[]{class277.field3718, class277.field3716, class277.field3713};
   }
}
