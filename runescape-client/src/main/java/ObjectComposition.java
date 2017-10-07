import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ic")
@Implements("ObjectComposition")
public class ObjectComposition extends CacheableNode {
   @ObfuscatedName("d")
   static boolean field3481;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lgl;"
   )
   @Export("objects")
   public static NodeCache objects;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lit;"
   )
   static IndexDataBase field3446;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lit;"
   )
   @Export("objects_ref")
   static IndexDataBase objects_ref;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lgl;"
   )
   public static NodeCache field3477;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lgl;"
   )
   @Export("cachedModels")
   public static NodeCache cachedModels;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lgl;"
   )
   public static NodeCache field3484;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "[Ldl;"
   )
   static ModelData[] field3444;
   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "Lgc;"
   )
   IterableHashTable field3487;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -2007319755
   )
   @Export("varpId")
   int varpId;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 2068176517
   )
   public int field3439;
   @ObfuscatedName("t")
   @Export("objectModels")
   int[] objectModels;
   @ObfuscatedName("y")
   @Export("objectTypes")
   int[] objectTypes;
   @ObfuscatedName("ap")
   @Export("impostorIds")
   public int[] impostorIds;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = -627066873
   )
   @Export("ambientSoundId")
   public int ambientSoundId;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = 723543919
   )
   @Export("configId")
   int configId;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = -738432739
   )
   public int field3478;
   @ObfuscatedName("o")
   @Export("name")
   public String name;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -418589219
   )
   @Export("id")
   public int id;
   @ObfuscatedName("al")
   public int[] field3486;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = -557224971
   )
   @Export("mapIconId")
   public int mapIconId;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -542672009
   )
   @Export("sizeX")
   public int sizeX;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1384239143
   )
   @Export("interactType")
   public int interactType;
   @ObfuscatedName("ag")
   @Export("isRotated")
   boolean isRotated;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1751251073
   )
   @Export("sizeY")
   public int sizeY;
   @ObfuscatedName("h")
   public boolean field3456;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -147888123
   )
   public int field3483;
   @ObfuscatedName("l")
   @Export("nonFlatShading")
   boolean nonFlatShading;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1517529303
   )
   @Export("clipType")
   int clipType;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = 621993497
   )
   public int field3445;
   @ObfuscatedName("w")
   @Export("modelClipped")
   public boolean modelClipped;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 1287802635
   )
   @Export("ambient")
   int ambient;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = 914039623
   )
   @Export("contrast")
   int contrast;
   @ObfuscatedName("ah")
   @Export("actions")
   public String[] actions;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = -1884831083
   )
   public int field3470;
   @ObfuscatedName("aa")
   @Export("isSolid")
   boolean isSolid;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -341807243
   )
   @Export("animationId")
   public int animationId;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = 1879543007
   )
   @Export("modelSizeX")
   int modelSizeX;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1733761645
   )
   public int field3462;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = -1485006983
   )
   @Export("modelSizeHeight")
   int modelSizeHeight;
   @ObfuscatedName("i")
   @Export("recolorToFind")
   short[] recolorToFind;
   @ObfuscatedName("as")
   @Export("clipped")
   public boolean clipped;
   @ObfuscatedName("b")
   @Export("textureToFind")
   short[] textureToFind;
   @ObfuscatedName("u")
   @Export("recolorToReplace")
   short[] recolorToReplace;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = -1150395495
   )
   @Export("modelSizeY")
   int modelSizeY;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = 669239031
   )
   @Export("mapSceneId")
   public int mapSceneId;
   @ObfuscatedName("f")
   @Export("textureToReplace")
   short[] textureToReplace;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = -2055037863
   )
   @Export("offsetX")
   int offsetX;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = 1324924501
   )
   @Export("offsetHeight")
   int offsetHeight;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = -675625727
   )
   @Export("offsetY")
   int offsetY;
   @ObfuscatedName("ar")
   public boolean field3476;

   static {
      field3481 = false;
      objects = new NodeCache(4096);
      field3484 = new NodeCache(500);
      cachedModels = new NodeCache(30);
      field3477 = new NodeCache(30);
      field3444 = new ModelData[4];
   }

   ObjectComposition() {
      this.name = "null";
      this.sizeX = 1;
      this.sizeY = 1;
      this.interactType = 2;
      this.field3456 = true;
      this.field3439 = -1;
      this.clipType = -1;
      this.nonFlatShading = false;
      this.modelClipped = false;
      this.animationId = -1;
      this.field3462 = 16;
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
      this.field3476 = false;
      this.isSolid = false;
      this.field3478 = -1;
      this.varpId = -1;
      this.configId = -1;
      this.ambientSoundId = -1;
      this.field3483 = 0;
      this.field3445 = 0;
      this.field3470 = 0;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(B)Lic;",
      garbageValue = "42"
   )
   @Export("getImpostor")
   public final ObjectComposition getImpostor() {
      int var1 = -1;
      if(this.varpId != -1) {
         var1 = class88.method1777(this.varpId);
      } else if(this.configId != -1) {
         var1 = class211.widgetSettings[this.configId];
      }

      int var2;
      if(var1 >= 0 && var1 < this.impostorIds.length - 1) {
         var2 = this.impostorIds[var1];
      } else {
         var2 = this.impostorIds[this.impostorIds.length - 1];
      }

      return var2 != -1?Occluder.getObjectDefinition(var2):null;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lfg;II)V",
      garbageValue = "554088590"
   )
   @Export("loadData")
   void loadData(Buffer var1, int var2) {
      int var3;
      int var4;
      if(var2 == 1) {
         var3 = var1.readUnsignedByte();
         if(var3 > 0) {
            if(this.objectModels != null && !field3481) {
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
            if(this.objectModels != null && !field3481) {
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
         this.field3456 = false;
      } else if(var2 == 18) {
         this.field3456 = false;
      } else if(var2 == 19) {
         this.field3439 = var1.readUnsignedByte();
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
         this.field3462 = var1.readUnsignedByte();
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
         this.field3476 = true;
      } else if(var2 == 74) {
         this.isSolid = true;
      } else if(var2 == 75) {
         this.field3478 = var1.readUnsignedByte();
      } else if(var2 != 77 && var2 != 92) {
         if(var2 == 78) {
            this.ambientSoundId = var1.readUnsignedShort();
            this.field3483 = var1.readUnsignedByte();
         } else if(var2 == 79) {
            this.field3445 = var1.readUnsignedShort();
            this.field3470 = var1.readUnsignedShort();
            this.field3483 = var1.readUnsignedByte();
            var3 = var1.readUnsignedByte();
            this.field3486 = new int[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field3486[var4] = var1.readUnsignedShort();
            }
         } else if(var2 == 81) {
            this.clipType = var1.readUnsignedByte() * 256;
         } else if(var2 == 82) {
            this.mapIconId = var1.readUnsignedShort();
         } else if(var2 == 249) {
            this.field3487 = class41.method590(var1, this.field3487);
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

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(III)Ldl;",
      garbageValue = "16688039"
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

            var3 = (ModelData)field3484.get((long)var7);
            if(var3 == null) {
               var3 = ModelData.method2498(field3446, var7 & '\uffff', 0);
               if(var3 == null) {
                  return null;
               }

               if(var4) {
                  var3.method2547();
               }

               field3484.put(var3, (long)var7);
            }

            if(var5 > 1) {
               field3444[var6] = var3;
            }
         }

         if(var5 > 1) {
            var3 = new ModelData(field3444, var5);
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

         var3 = (ModelData)field3484.get((long)var5);
         if(var3 == null) {
            var3 = ModelData.method2498(field3446, var5 & '\uffff', 0);
            if(var3 == null) {
               return null;
            }

            if(var10) {
               var3.method2547();
            }

            field3484.put(var3, (long)var5);
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
         var8.method2510(256);
         var8.method2511(45, 0, -45);
      }

      var2 &= 3;
      if(var2 == 1) {
         var8.method2507();
      } else if(var2 == 2) {
         var8.method2539();
      } else if(var2 == 3) {
         var8.method2543();
      }

      if(this.recolorToFind != null) {
         for(var7 = 0; var7 < this.recolorToFind.length; ++var7) {
            var8.recolor(this.recolorToFind[var7], this.recolorToReplace[var7]);
         }
      }

      if(this.textureToFind != null) {
         for(var7 = 0; var7 < this.textureToFind.length; ++var7) {
            var8.method2513(this.textureToFind[var7], this.textureToReplace[var7]);
         }
      }

      if(var4) {
         var8.method2515(this.modelSizeX, this.modelSizeHeight, this.modelSizeY);
      }

      if(var11) {
         var8.method2511(this.offsetX, this.offsetHeight, this.offsetY);
      }

      return var8;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1879826410"
   )
   @Export("post")
   void post() {
      if(this.field3439 == -1) {
         this.field3439 = 0;
         if(this.objectModels != null && (this.objectTypes == null || this.objectTypes[0] == 10)) {
            this.field3439 = 1;
         }

         for(int var1 = 0; var1 < 5; ++var1) {
            if(this.actions[var1] != null) {
               this.field3439 = 1;
            }
         }
      }

      if(this.field3478 == -1) {
         this.field3478 = this.interactType != 0?1:0;
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lfg;I)V",
      garbageValue = "-748855747"
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

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(II[[IIIILjl;II)Leb;",
      garbageValue = "-2073407372"
   )
   public final Model method4615(int var1, int var2, int[][] var3, int var4, int var5, int var6, Sequence var7, int var8) {
      long var9;
      if(this.objectTypes == null) {
         var9 = (long)(var2 + (this.id << 10));
      } else {
         var9 = (long)(var2 + (var1 << 3) + (this.id << 10));
      }

      Model var11 = (Model)field3477.get(var9);
      if(var11 == null) {
         ModelData var12 = this.getModel(var1, var2);
         if(var12 == null) {
            return null;
         }

         var11 = var12.light(this.ambient + 64, this.contrast + 768, -50, -10, -50);
         field3477.put(var11, var9);
      }

      if(var7 == null && this.clipType == -1) {
         return var11;
      } else {
         if(var7 != null) {
            var11 = var7.method4811(var11, var8, var2);
         } else {
            var11 = var11.method2641(true);
         }

         if(this.clipType >= 0) {
            var11 = var11.method2589(var3, var4, var5, var6, false, this.clipType);
         }

         return var11;
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "64"
   )
   public final boolean method4619() {
      if(this.objectModels == null) {
         return true;
      } else {
         boolean var1 = true;

         for(int var2 = 0; var2 < this.objectModels.length; ++var2) {
            var1 &= field3446.method4237(this.objectModels[var2] & '\uffff', 0);
         }

         return var1;
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "0"
   )
   public final boolean method4634(int var1) {
      if(this.objectTypes != null) {
         for(int var4 = 0; var4 < this.objectTypes.length; ++var4) {
            if(this.objectTypes[var4] == var1) {
               return field3446.method4237(this.objectModels[var4] & '\uffff', 0);
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
            var2 &= field3446.method4237(this.objectModels[var3] & '\uffff', 0);
         }

         return var2;
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(II[[IIIII)Leb;",
      garbageValue = "-1074894650"
   )
   public final Model method4614(int var1, int var2, int[][] var3, int var4, int var5, int var6) {
      long var7;
      if(this.objectTypes == null) {
         var7 = (long)(var2 + (this.id << 10));
      } else {
         var7 = (long)(var2 + (var1 << 3) + (this.id << 10));
      }

      Model var9 = (Model)field3477.get(var7);
      if(var9 == null) {
         ModelData var10 = this.getModel(var1, var2);
         if(var10 == null) {
            return null;
         }

         var9 = var10.light(this.ambient + 64, this.contrast + 768, -50, -10, -50);
         field3477.put(var9, var7);
      }

      if(this.clipType >= 0) {
         var9 = var9.method2589(var3, var4, var5, var6, true, this.clipType);
      }

      return var9;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "4"
   )
   public boolean method4633() {
      if(this.impostorIds == null) {
         return this.ambientSoundId != -1 || this.field3486 != null;
      } else {
         for(int var1 = 0; var1 < this.impostorIds.length; ++var1) {
            if(this.impostorIds[var1] != -1) {
               ObjectComposition var2 = Occluder.getObjectDefinition(this.impostorIds[var1]);
               if(var2.ambientSoundId != -1 || var2.field3486 != null) {
                  return true;
               }
            }
         }

         return false;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II[[IIIII)Lee;",
      garbageValue = "856316048"
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
            var10.field1823 = (short)(this.ambient + 64);
            var10.contrast = (short)(this.contrast + 768);
            var10.computeNormals();
            var9 = var10;
         }

         cachedModels.put((CacheableNode)var9, var7);
      }

      if(this.nonFlatShading) {
         var9 = ((ModelData)var9).method2505();
      }

      if(this.clipType >= 0) {
         if(var9 instanceof Model) {
            var9 = ((Model)var9).method2589(var3, var4, var5, var6, true, this.clipType);
         } else if(var9 instanceof ModelData) {
            var9 = ((ModelData)var9).method2506(var3, var4, var5, var6, true, this.clipType);
         }
      }

      return (Renderable)var9;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;B)Ljava/lang/String;",
      garbageValue = "69"
   )
   public String method4618(int var1, String var2) {
      return class85.method1769(this.field3487, var1, var2);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-948584033"
   )
   public int method4620(int var1, int var2) {
      return FileSystem.method4214(this.field3487, var1, var2);
   }
}
