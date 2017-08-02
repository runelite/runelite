import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("it")
@Implements("ObjectComposition")
public class ObjectComposition extends CacheableNode {
   @ObfuscatedName("c")
   public static boolean field3428;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lgq;"
   )
   @Export("objects")
   public static NodeCache objects;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lip;"
   )
   @Export("objects_ref")
   public static IndexDataBase objects_ref;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lgq;"
   )
   public static NodeCache field3413;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lgq;"
   )
   @Export("cachedModels")
   public static NodeCache cachedModels;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lgq;"
   )
   public static NodeCache field3443;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "[Ldj;"
   )
   static ModelData[] field3461;
   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "Lgk;"
   )
   IterableHashTable field3459;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -561417545
   )
   @Export("varpId")
   int varpId;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1438911353
   )
   public int field3429;
   @ObfuscatedName("k")
   @Export("objectModels")
   int[] objectModels;
   @ObfuscatedName("r")
   @Export("objectTypes")
   int[] objectTypes;
   @ObfuscatedName("ah")
   @Export("impostorIds")
   public int[] impostorIds;
   @ObfuscatedName("w")
   @Export("name")
   public String name;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = 1249356229
   )
   @Export("ambientSoundId")
   public int ambientSoundId;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = 755096353
   )
   @Export("configId")
   int configId;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 1591673553
   )
   public int field3431;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1726985915
   )
   @Export("id")
   public int id;
   @ObfuscatedName("az")
   public int[] field3458;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = -927644781
   )
   @Export("mapIconId")
   public int mapIconId;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -676757325
   )
   @Export("sizeX")
   public int sizeX;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1120012875
   )
   @Export("interactType")
   public int interactType;
   @ObfuscatedName("al")
   @Export("isRotated")
   boolean isRotated;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 830438371
   )
   @Export("sizeY")
   public int sizeY;
   @ObfuscatedName("q")
   public boolean field3439;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = -638590239
   )
   public int field3455;
   @ObfuscatedName("n")
   @Export("nonFlatShading")
   boolean nonFlatShading;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -713628495
   )
   @Export("clipType")
   int clipType;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = -745342531
   )
   public int field3456;
   @ObfuscatedName("z")
   @Export("modelClipped")
   public boolean modelClipped;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = -1428460125
   )
   @Export("ambient")
   int ambient;
   @ObfuscatedName("am")
   @Export("actions")
   public String[] actions;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = 300333829
   )
   @Export("contrast")
   int contrast;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = 396625945
   )
   public int field3418;
   @ObfuscatedName("ac")
   @Export("isSolid")
   boolean isSolid;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 472835945
   )
   @Export("animationId")
   public int animationId;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = -480743933
   )
   @Export("modelSizeX")
   int modelSizeX;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 347722521
   )
   public int field3447;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = 472160175
   )
   @Export("modelSizeHeight")
   int modelSizeHeight;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = -1432945669
   )
   @Export("modelSizeY")
   int modelSizeY;
   @ObfuscatedName("v")
   @Export("recolorToFind")
   short[] recolorToFind;
   @ObfuscatedName("ab")
   @Export("clipped")
   public boolean clipped;
   @ObfuscatedName("t")
   @Export("textureToFind")
   short[] textureToFind;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = 981090673
   )
   @Export("mapSceneId")
   public int mapSceneId;
   @ObfuscatedName("h")
   @Export("recolorToReplace")
   short[] recolorToReplace;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = 245857723
   )
   @Export("offsetX")
   int offsetX;
   @ObfuscatedName("a")
   @Export("textureToReplace")
   short[] textureToReplace;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = -1706726661
   )
   @Export("offsetHeight")
   int offsetHeight;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = 450529513
   )
   @Export("offsetY")
   int offsetY;
   @ObfuscatedName("ad")
   public boolean field3448;

   static {
      field3428 = false;
      objects = new NodeCache(4096);
      field3443 = new NodeCache(500);
      cachedModels = new NodeCache(30);
      field3413 = new NodeCache(30);
      field3461 = new ModelData[4];
   }

   ObjectComposition() {
      this.name = "null";
      this.sizeX = 1;
      this.sizeY = 1;
      this.interactType = 2;
      this.field3439 = true;
      this.field3429 = -1;
      this.clipType = -1;
      this.nonFlatShading = false;
      this.modelClipped = false;
      this.animationId = -1;
      this.field3447 = 16;
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
      this.field3448 = false;
      this.isSolid = false;
      this.field3431 = -1;
      this.varpId = -1;
      this.configId = -1;
      this.ambientSoundId = -1;
      this.field3455 = 0;
      this.field3456 = 0;
      this.field3418 = 0;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)Lit;",
      garbageValue = "-305862143"
   )
   @Export("getImpostor")
   public final ObjectComposition getImpostor() {
      int var1 = -1;
      if(this.varpId != -1) {
         var1 = class17.method125(this.varpId);
      } else if(this.configId != -1) {
         var1 = class211.widgetSettings[this.configId];
      }

      int var2;
      if(var1 >= 0 && var1 < this.impostorIds.length - 1) {
         var2 = this.impostorIds[var1];
      } else {
         var2 = this.impostorIds[this.impostorIds.length - 1];
      }

      return var2 != -1?class169.getObjectDefinition(var2):null;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lfp;IB)V",
      garbageValue = "125"
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
         this.interactType = 0;
         this.field3439 = false;
      } else if(var2 == 18) {
         this.field3439 = false;
      } else if(var2 == 19) {
         this.field3429 = var1.readUnsignedByte();
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
         this.field3447 = var1.readUnsignedByte();
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
         this.field3448 = true;
      } else if(var2 == 74) {
         this.isSolid = true;
      } else if(var2 == 75) {
         this.field3431 = var1.readUnsignedByte();
      } else if(var2 != 77 && var2 != 92) {
         if(var2 == 78) {
            this.ambientSoundId = var1.readUnsignedShort();
            this.field3455 = var1.readUnsignedByte();
         } else if(var2 == 79) {
            this.field3456 = var1.readUnsignedShort();
            this.field3418 = var1.readUnsignedShort();
            this.field3455 = var1.readUnsignedByte();
            var3 = var1.readUnsignedByte();
            this.field3458 = new int[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field3458[var4] = var1.readUnsignedShort();
            }
         } else if(var2 == 81) {
            this.clipType = var1.readUnsignedByte() * 256;
         } else if(var2 == 82) {
            this.mapIconId = var1.readUnsignedShort();
         } else if(var2 == 249) {
            this.field3459 = class46.method629(var1, this.field3459);
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

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIB)Ldj;",
      garbageValue = "-105"
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

            var3 = (ModelData)field3443.get((long)var7);
            if(var3 == null) {
               var3 = ModelData.method2331(class37.field511, var7 & '\uffff', 0);
               if(var3 == null) {
                  return null;
               }

               if(var4) {
                  var3.method2348();
               }

               field3443.put(var3, (long)var7);
            }

            if(var5 > 1) {
               field3461[var6] = var3;
            }
         }

         if(var5 > 1) {
            var3 = new ModelData(field3461, var5);
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

         var3 = (ModelData)field3443.get((long)var5);
         if(var3 == null) {
            var3 = ModelData.method2331(class37.field511, var5 & '\uffff', 0);
            if(var3 == null) {
               return null;
            }

            if(var10) {
               var3.method2348();
            }

            field3443.put(var3, (long)var5);
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
         var8.method2379(256);
         var8.method2345(45, 0, -45);
      }

      var2 &= 3;
      if(var2 == 1) {
         var8.method2341();
      } else if(var2 == 2) {
         var8.method2342();
      } else if(var2 == 3) {
         var8.method2343();
      }

      if(this.recolorToFind != null) {
         for(var7 = 0; var7 < this.recolorToFind.length; ++var7) {
            var8.recolor(this.recolorToFind[var7], this.recolorToReplace[var7]);
         }
      }

      if(this.textureToFind != null) {
         for(var7 = 0; var7 < this.textureToFind.length; ++var7) {
            var8.method2347(this.textureToFind[var7], this.textureToReplace[var7]);
         }
      }

      if(var4) {
         var8.method2349(this.modelSizeX, this.modelSizeHeight, this.modelSizeY);
      }

      if(var11) {
         var8.method2345(this.offsetX, this.offsetHeight, this.offsetY);
      }

      return var8;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "460289174"
   )
   @Export("post")
   void post() {
      if(this.field3429 == -1) {
         this.field3429 = 0;
         if(this.objectModels != null && (this.objectTypes == null || this.objectTypes[0] == 10)) {
            this.field3429 = 1;
         }

         for(int var1 = 0; var1 < 5; ++var1) {
            if(this.actions[var1] != null) {
               this.field3429 = 1;
            }
         }
      }

      if(this.field3431 == -1) {
         this.field3431 = this.interactType != 0?1:0;
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lfp;I)V",
      garbageValue = "-2022569522"
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

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II[[IIIILjc;IB)Leo;",
      garbageValue = "-38"
   )
   public final Model method4405(int var1, int var2, int[][] var3, int var4, int var5, int var6, Sequence var7, int var8) {
      long var9;
      if(this.objectTypes == null) {
         var9 = (long)(var2 + (this.id << 10));
      } else {
         var9 = (long)((var1 << 3) + var2 + (this.id << 10));
      }

      Model var11 = (Model)field3413.get(var9);
      if(var11 == null) {
         ModelData var12 = this.getModel(var1, var2);
         if(var12 == null) {
            return null;
         }

         var11 = var12.light(this.ambient + 64, this.contrast + 768, -50, -10, -50);
         field3413.put(var11, var9);
      }

      if(var7 == null && this.clipType == -1) {
         return var11;
      } else {
         if(var7 != null) {
            var11 = var7.method4580(var11, var8, var2);
         } else {
            var11 = var11.method2429(true);
         }

         if(this.clipType >= 0) {
            var11 = var11.method2477(var3, var4, var5, var6, false, this.clipType);
         }

         return var11;
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "2134973670"
   )
   public final boolean method4402() {
      if(this.objectModels == null) {
         return true;
      } else {
         boolean var1 = true;

         for(int var2 = 0; var2 < this.objectModels.length; ++var2) {
            var1 &= class37.field511.method4010(this.objectModels[var2] & '\uffff', 0);
         }

         return var1;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "8"
   )
   public final boolean method4401(int var1) {
      if(this.objectTypes != null) {
         for(int var4 = 0; var4 < this.objectTypes.length; ++var4) {
            if(this.objectTypes[var4] == var1) {
               return class37.field511.method4010(this.objectModels[var4] & '\uffff', 0);
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
            var2 &= class37.field511.method4010(this.objectModels[var3] & '\uffff', 0);
         }

         return var2;
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II[[IIIII)Leo;",
      garbageValue = "1510392669"
   )
   public final Model method4404(int var1, int var2, int[][] var3, int var4, int var5, int var6) {
      long var7;
      if(this.objectTypes == null) {
         var7 = (long)(var2 + (this.id << 10));
      } else {
         var7 = (long)((var1 << 3) + var2 + (this.id << 10));
      }

      Model var9 = (Model)field3413.get(var7);
      if(var9 == null) {
         ModelData var10 = this.getModel(var1, var2);
         if(var10 == null) {
            return null;
         }

         var9 = var10.light(this.ambient + 64, this.contrast + 768, -50, -10, -50);
         field3413.put(var9, var7);
      }

      if(this.clipType >= 0) {
         var9 = var9.method2477(var3, var4, var5, var6, true, this.clipType);
      }

      return var9;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "42"
   )
   public int method4432(int var1, int var2) {
      return class112.method2023(this.field3459, var1, var2);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)Ljava/lang/String;",
      garbageValue = "-288782575"
   )
   public String method4441(int var1, String var2) {
      return class232.method4001(this.field3459, var1, var2);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1038350024"
   )
   public boolean method4410() {
      if(this.impostorIds == null) {
         return this.ambientSoundId != -1 || this.field3458 != null;
      } else {
         for(int var1 = 0; var1 < this.impostorIds.length; ++var1) {
            if(this.impostorIds[var1] != -1) {
               ObjectComposition var2 = class169.getObjectDefinition(this.impostorIds[var1]);
               if(var2.ambientSoundId != -1 || var2.field3458 != null) {
                  return true;
               }
            }
         }

         return false;
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II[[IIIII)Lev;",
      garbageValue = "-123154341"
   )
   @Export("getModel")
   public final Renderable getModel(int var1, int var2, int[][] var3, int var4, int var5, int var6) {
      long var7;
      if(this.objectTypes == null) {
         var7 = (long)(var2 + (this.id << 10));
      } else {
         var7 = (long)((var1 << 3) + var2 + (this.id << 10));
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
            var10.field1763 = (short)(this.ambient + 64);
            var10.contrast = (short)(this.contrast + 768);
            var10.computeNormals();
            var9 = var10;
         }

         cachedModels.put((CacheableNode)var9, var7);
      }

      if(this.nonFlatShading) {
         var9 = ((ModelData)var9).method2399();
      }

      if(this.clipType >= 0) {
         if(var9 instanceof Model) {
            var9 = ((Model)var9).method2477(var3, var4, var5, var6, true, this.clipType);
         } else if(var9 instanceof ModelData) {
            var9 = ((ModelData)var9).method2339(var3, var4, var5, var6, true, this.clipType);
         }
      }

      return (Renderable)var9;
   }
}
