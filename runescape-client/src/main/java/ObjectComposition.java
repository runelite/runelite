import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iv")
@Implements("ObjectComposition")
public class ObjectComposition extends CacheableNode {
   @ObfuscatedName("d")
   static boolean field3439;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lgg;"
   )
   @Export("objects")
   public static NodeCache objects;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lim;"
   )
   static IndexDataBase field3446;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lim;"
   )
   @Export("objects_ref")
   static IndexDataBase objects_ref;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lgg;"
   )
   public static NodeCache field3420;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lgg;"
   )
   @Export("cachedModels")
   public static NodeCache cachedModels;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lgg;"
   )
   public static NodeCache field3447;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "[Ldk;"
   )
   static ModelData[] field3421;
   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "Lgc;"
   )
   IterableHashTable field3418;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = 373781865
   )
   @Export("varpId")
   int varpId;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1348360135
   )
   public int field3463;
   @ObfuscatedName("r")
   @Export("objectModels")
   int[] objectModels;
   @ObfuscatedName("g")
   @Export("objectTypes")
   int[] objectTypes;
   @ObfuscatedName("an")
   @Export("impostorIds")
   public int[] impostorIds;
   @ObfuscatedName("s")
   @Export("name")
   public String name;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = 146194681
   )
   @Export("ambientSoundId")
   public int ambientSoundId;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = -161612853
   )
   @Export("configId")
   int configId;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = 720926069
   )
   public int field3432;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 257922287
   )
   @Export("id")
   public int id;
   @ObfuscatedName("al")
   public int[] field3449;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = 1941762869
   )
   @Export("mapIconId")
   public int mapIconId;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1209551211
   )
   @Export("sizeX")
   public int sizeX;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -256536641
   )
   @Export("interactType")
   public int interactType;
   @ObfuscatedName("ar")
   @Export("isRotated")
   boolean isRotated;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1380808009
   )
   @Export("sizeY")
   public int sizeY;
   @ObfuscatedName("c")
   public boolean field3459;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = -939091283
   )
   public int field3460;
   @ObfuscatedName("a")
   @Export("nonFlatShading")
   boolean nonFlatShading;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 993476321
   )
   @Export("clipType")
   int clipType;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = -396430609
   )
   public int field3461;
   @ObfuscatedName("h")
   @Export("modelClipped")
   public boolean modelClipped;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = -696697091
   )
   @Export("ambient")
   int ambient;
   @ObfuscatedName("ax")
   @Export("actions")
   public String[] actions;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = 1579493855
   )
   @Export("contrast")
   int contrast;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = 1143768103
   )
   public int field3462;
   @ObfuscatedName("aq")
   @Export("isSolid")
   boolean isSolid;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -921054791
   )
   @Export("animationId")
   public int animationId;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = 1332196665
   )
   @Export("modelSizeX")
   int modelSizeX;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1200818499
   )
   public int field3435;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = 111705443
   )
   @Export("modelSizeHeight")
   int modelSizeHeight;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = -294490751
   )
   @Export("modelSizeY")
   int modelSizeY;
   @ObfuscatedName("o")
   @Export("recolorToFind")
   short[] recolorToFind;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = -194274927
   )
   @Export("mapSceneId")
   public int mapSceneId;
   @ObfuscatedName("ae")
   @Export("clipped")
   public boolean clipped;
   @ObfuscatedName("u")
   @Export("textureToFind")
   short[] textureToFind;
   @ObfuscatedName("p")
   @Export("recolorToReplace")
   short[] recolorToReplace;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = -1231306561
   )
   @Export("offsetX")
   int offsetX;
   @ObfuscatedName("b")
   @Export("textureToReplace")
   short[] textureToReplace;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = 1351508869
   )
   @Export("offsetHeight")
   int offsetHeight;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = 1439519787
   )
   @Export("offsetY")
   int offsetY;
   @ObfuscatedName("az")
   public boolean field3442;

   static {
      field3439 = false;
      objects = new NodeCache(4096);
      field3447 = new NodeCache(500);
      cachedModels = new NodeCache(30);
      field3420 = new NodeCache(30);
      field3421 = new ModelData[4];
   }

   ObjectComposition() {
      this.name = "null";
      this.sizeX = 1;
      this.sizeY = 1;
      this.interactType = 2;
      this.field3459 = true;
      this.field3463 = -1;
      this.clipType = -1;
      this.nonFlatShading = false;
      this.modelClipped = false;
      this.animationId = -1;
      this.field3435 = 16;
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
      this.field3442 = false;
      this.isSolid = false;
      this.field3432 = -1;
      this.varpId = -1;
      this.configId = -1;
      this.ambientSoundId = -1;
      this.field3460 = 0;
      this.field3461 = 0;
      this.field3462 = 0;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)Liv;",
      garbageValue = "1132307583"
   )
   @Export("getImpostor")
   public final ObjectComposition getImpostor() {
      int var1 = -1;
      if(this.varpId != -1) {
         var1 = class90.method1720(this.varpId);
      } else if(this.configId != -1) {
         var1 = class211.widgetSettings[this.configId];
      }

      int var2;
      if(var1 >= 0 && var1 < this.impostorIds.length - 1) {
         var2 = this.impostorIds[var1];
      } else {
         var2 = this.impostorIds[this.impostorIds.length - 1];
      }

      return var2 != -1?WidgetNode.getObjectDefinition(var2):null;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lfw;IB)V",
      garbageValue = "2"
   )
   @Export("loadData")
   void loadData(Buffer var1, int var2) {
      int var3;
      int var4;
      if(var2 == 1) {
         var3 = var1.readUnsignedByte();
         if(var3 > 0) {
            if(this.objectModels != null && !field3439) {
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
            if(this.objectModels != null && !field3439) {
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
         this.field3459 = false;
      } else if(var2 == 18) {
         this.field3459 = false;
      } else if(var2 == 19) {
         this.field3463 = var1.readUnsignedByte();
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
         this.field3442 = true;
      } else if(var2 == 74) {
         this.isSolid = true;
      } else if(var2 == 75) {
         this.field3432 = var1.readUnsignedByte();
      } else if(var2 != 77 && var2 != 92) {
         if(var2 == 78) {
            this.ambientSoundId = var1.readUnsignedShort();
            this.field3460 = var1.readUnsignedByte();
         } else if(var2 == 79) {
            this.field3461 = var1.readUnsignedShort();
            this.field3462 = var1.readUnsignedShort();
            this.field3460 = var1.readUnsignedByte();
            var3 = var1.readUnsignedByte();
            this.field3449 = new int[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field3449[var4] = var1.readUnsignedShort();
            }
         } else if(var2 == 81) {
            this.clipType = var1.readUnsignedByte() * 256;
         } else if(var2 == 82) {
            this.mapIconId = var1.readUnsignedShort();
         } else if(var2 == 249) {
            this.field3418 = FrameMap.method2698(var1, this.field3418);
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
      signature = "(III)Ldk;",
      garbageValue = "21824583"
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

            var3 = (ModelData)field3447.get((long)var7);
            if(var3 == null) {
               var3 = ModelData.method2477(field3446, var7 & '\uffff', 0);
               if(var3 == null) {
                  return null;
               }

               if(var4) {
                  var3.method2430();
               }

               field3447.put(var3, (long)var7);
            }

            if(var5 > 1) {
               field3421[var6] = var3;
            }
         }

         if(var5 > 1) {
            var3 = new ModelData(field3421, var5);
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

         var3 = (ModelData)field3447.get((long)var5);
         if(var3 == null) {
            var3 = ModelData.method2477(field3446, var5 & '\uffff', 0);
            if(var3 == null) {
               return null;
            }

            if(var10) {
               var3.method2430();
            }

            field3447.put(var3, (long)var5);
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
         var8.method2426(256);
         var8.method2427(45, 0, -45);
      }

      var2 &= 3;
      if(var2 == 1) {
         var8.method2416();
      } else if(var2 == 2) {
         var8.method2422();
      } else if(var2 == 3) {
         var8.method2425();
      }

      if(this.recolorToFind != null) {
         for(var7 = 0; var7 < this.recolorToFind.length; ++var7) {
            var8.recolor(this.recolorToFind[var7], this.recolorToReplace[var7]);
         }
      }

      if(this.textureToFind != null) {
         for(var7 = 0; var7 < this.textureToFind.length; ++var7) {
            var8.method2429(this.textureToFind[var7], this.textureToReplace[var7]);
         }
      }

      if(var4) {
         var8.method2431(this.modelSizeX, this.modelSizeHeight, this.modelSizeY);
      }

      if(var11) {
         var8.method2427(this.offsetX, this.offsetHeight, this.offsetY);
      }

      return var8;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "4"
   )
   @Export("post")
   void post() {
      if(this.field3463 == -1) {
         this.field3463 = 0;
         if(this.objectModels != null && (this.objectTypes == null || this.objectTypes[0] == 10)) {
            this.field3463 = 1;
         }

         for(int var1 = 0; var1 < 5; ++var1) {
            if(this.actions[var1] != null) {
               this.field3463 = 1;
            }
         }
      }

      if(this.field3432 == -1) {
         this.field3432 = this.interactType != 0?1:0;
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Lfw;I)V",
      garbageValue = "-373944153"
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
      signature = "(II[[IIIILjj;II)Lev;",
      garbageValue = "1537462547"
   )
   public final Model method4514(int var1, int var2, int[][] var3, int var4, int var5, int var6, Sequence var7, int var8) {
      long var9;
      if(this.objectTypes == null) {
         var9 = (long)(var2 + (this.id << 10));
      } else {
         var9 = (long)((var1 << 3) + var2 + (this.id << 10));
      }

      Model var11 = (Model)field3420.get(var9);
      if(var11 == null) {
         ModelData var12 = this.getModel(var1, var2);
         if(var12 == null) {
            return null;
         }

         var11 = var12.light(this.ambient + 64, this.contrast + 768, -50, -10, -50);
         field3420.put(var11, var9);
      }

      if(var7 == null && this.clipType == -1) {
         return var11;
      } else {
         if(var7 != null) {
            var11 = var7.method4683(var11, var8, var2);
         } else {
            var11 = var11.method2505(true);
         }

         if(this.clipType >= 0) {
            var11 = var11.method2504(var3, var4, var5, var6, false, this.clipType);
         }

         return var11;
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1777339070"
   )
   public final boolean method4497() {
      if(this.objectModels == null) {
         return true;
      } else {
         boolean var1 = true;

         for(int var2 = 0; var2 < this.objectModels.length; ++var2) {
            var1 &= field3446.method4115(this.objectModels[var2] & '\uffff', 0);
         }

         return var1;
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "1764677148"
   )
   public final boolean method4496(int var1) {
      if(this.objectTypes != null) {
         for(int var4 = 0; var4 < this.objectTypes.length; ++var4) {
            if(this.objectTypes[var4] == var1) {
               return field3446.method4115(this.objectModels[var4] & '\uffff', 0);
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
            var2 &= field3446.method4115(this.objectModels[var3] & '\uffff', 0);
         }

         return var2;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "73"
   )
   public boolean method4505() {
      if(this.impostorIds == null) {
         return this.ambientSoundId != -1 || this.field3449 != null;
      } else {
         for(int var1 = 0; var1 < this.impostorIds.length; ++var1) {
            if(this.impostorIds[var1] != -1) {
               ObjectComposition var2 = WidgetNode.getObjectDefinition(this.impostorIds[var1]);
               if(var2.ambientSoundId != -1 || var2.field3449 != null) {
                  return true;
               }
            }
         }

         return false;
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(II[[IIIII)Lep;",
      garbageValue = "1598903751"
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
            var10.field1768 = (short)(this.ambient + 64);
            var10.contrast = (short)(this.contrast + 768);
            var10.computeNormals();
            var9 = var10;
         }

         cachedModels.put((CacheableNode)var9, var7);
      }

      if(this.nonFlatShading) {
         var9 = ((ModelData)var9).method2420();
      }

      if(this.clipType >= 0) {
         if(var9 instanceof Model) {
            var9 = ((Model)var9).method2504(var3, var4, var5, var6, true, this.clipType);
         } else if(var9 instanceof ModelData) {
            var9 = ((ModelData)var9).method2447(var3, var4, var5, var6, true, this.clipType);
         }
      }

      return (Renderable)var9;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II[[IIIIB)Lev;",
      garbageValue = "33"
   )
   public final Model method4499(int var1, int var2, int[][] var3, int var4, int var5, int var6) {
      long var7;
      if(this.objectTypes == null) {
         var7 = (long)(var2 + (this.id << 10));
      } else {
         var7 = (long)((var1 << 3) + var2 + (this.id << 10));
      }

      Model var9 = (Model)field3420.get(var7);
      if(var9 == null) {
         ModelData var10 = this.getModel(var1, var2);
         if(var10 == null) {
            return null;
         }

         var9 = var10.light(this.ambient + 64, this.contrast + 768, -50, -10, -50);
         field3420.put(var9, var7);
      }

      if(this.clipType >= 0) {
         var9 = var9.method2504(var3, var4, var5, var6, true, this.clipType);
      }

      return var9;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "1"
   )
   public int method4533(int var1, int var2) {
      return class56.method835(this.field3418, var1, var2);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)Ljava/lang/String;",
      garbageValue = "-1778639636"
   )
   public String method4536(int var1, String var2) {
      return class33.method356(this.field3418, var1, var2);
   }
}
