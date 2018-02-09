import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ju")
@Implements("ObjectComposition")
public class ObjectComposition extends CacheableNode {
   @ObfuscatedName("s")
   @Export("objectCompositionLowDetail")
   public static boolean objectCompositionLowDetail;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lir;"
   )
   @Export("objects_ref")
   public static IndexDataBase objects_ref;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lir;"
   )
   public static IndexDataBase field3518;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lgc;"
   )
   @Export("objects")
   public static NodeCache objects;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lgc;"
   )
   public static NodeCache field3520;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lgc;"
   )
   @Export("cachedModels")
   public static NodeCache cachedModels;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lgc;"
   )
   public static NodeCache field3522;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "[Ldw;"
   )
   static ModelData[] field3523;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -479359763
   )
   @Export("id")
   public int id;
   @ObfuscatedName("k")
   @Export("objectModels")
   int[] objectModels;
   @ObfuscatedName("c")
   @Export("objectTypes")
   int[] objectTypes;
   @ObfuscatedName("o")
   @Export("name")
   public String name;
   @ObfuscatedName("l")
   @Export("recolorToFind")
   short[] recolorToFind;
   @ObfuscatedName("f")
   @Export("recolorToReplace")
   short[] recolorToReplace;
   @ObfuscatedName("q")
   @Export("textureToFind")
   short[] textureToFind;
   @ObfuscatedName("r")
   @Export("textureToReplace")
   short[] textureToReplace;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1988209415
   )
   @Export("width")
   public int width;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -563350825
   )
   @Export("length")
   public int length;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -579627267
   )
   @Export("clipType")
   public int clipType;
   @ObfuscatedName("p")
   @Export("blocksProjectile")
   public boolean blocksProjectile;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 316312725
   )
   @Export("int1")
   public int int1;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 783391193
   )
   @Export("contouredGround")
   int contouredGround;
   @ObfuscatedName("j")
   @Export("nonFlatShading")
   boolean nonFlatShading;
   @ObfuscatedName("e")
   @Export("modelClipped")
   public boolean modelClipped;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1906492543
   )
   @Export("animationId")
   public int animationId;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -214004785
   )
   @Export("decorDisplacement")
   public int decorDisplacement;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = -231267979
   )
   @Export("ambient")
   int ambient;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = -1993871189
   )
   @Export("contrast")
   int contrast;
   @ObfuscatedName("aq")
   @Export("actions")
   public String[] actions;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = 495566289
   )
   @Export("mapIconId")
   public int mapIconId;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = 59517907
   )
   @Export("mapSceneId")
   public int mapSceneId;
   @ObfuscatedName("af")
   @Export("isRotated")
   boolean isRotated;
   @ObfuscatedName("as")
   @Export("clipped")
   public boolean clipped;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = 1105039407
   )
   @Export("modelSizeX")
   int modelSizeX;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = 1942691307
   )
   @Export("modelSizeHeight")
   int modelSizeHeight;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = 1666444555
   )
   @Export("modelSizeY")
   int modelSizeY;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = -1599407559
   )
   @Export("offsetX")
   int offsetX;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = 1745026653
   )
   @Export("offsetHeight")
   int offsetHeight;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = 417112115
   )
   @Export("offsetY")
   int offsetY;
   @ObfuscatedName("ah")
   @Export("obstructsGround")
   public boolean obstructsGround;
   @ObfuscatedName("ag")
   @Export("isHollow")
   boolean isHollow;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = -1067636881
   )
   @Export("supportItems")
   public int supportItems;
   @ObfuscatedName("ae")
   @Export("impostorIds")
   public int[] impostorIds;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -2147371339
   )
   @Export("varpId")
   int varpId;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = 1875903489
   )
   @Export("configId")
   int configId;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = 1605773357
   )
   @Export("ambientSoundId")
   public int ambientSoundId;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = -455562389
   )
   @Export("int4")
   public int int4;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = 1807369347
   )
   @Export("int5")
   public int int5;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = 42142165
   )
   @Export("int6")
   public int int6;
   @ObfuscatedName("aa")
   public int[] field3565;
   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "Lgz;"
   )
   @Export("params")
   IterableHashTable params;

   static {
      objectCompositionLowDetail = false;
      objects = new NodeCache(4096);
      field3520 = new NodeCache(500);
      cachedModels = new NodeCache(30);
      field3522 = new NodeCache(30);
      field3523 = new ModelData[4];
   }

   ObjectComposition() {
      this.name = "null";
      this.width = 1;
      this.length = 1;
      this.clipType = 2;
      this.blocksProjectile = true;
      this.int1 = -1;
      this.contouredGround = -1;
      this.nonFlatShading = false;
      this.modelClipped = false;
      this.animationId = -1;
      this.decorDisplacement = 16;
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
      this.obstructsGround = false;
      this.isHollow = false;
      this.supportItems = -1;
      this.varpId = -1;
      this.configId = -1;
      this.ambientSoundId = -1;
      this.int4 = 0;
      this.int5 = 0;
      this.int6 = 0;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-63"
   )
   @Export("post")
   void post() {
      if(this.int1 == -1) {
         this.int1 = 0;
         if(this.objectModels != null && (this.objectTypes == null || this.objectTypes[0] == 10)) {
            this.int1 = 1;
         }

         for(int var1 = 0; var1 < 5; ++var1) {
            if(this.actions[var1] != null) {
               this.int1 = 1;
            }
         }
      }

      if(this.supportItems == -1) {
         this.supportItems = this.clipType != 0?1:0;
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lgy;I)V",
      garbageValue = "1731973548"
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

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lgy;II)V",
      garbageValue = "-1523873822"
   )
   @Export("loadData")
   void loadData(Buffer var1, int var2) {
      int var3;
      int var4;
      if(var2 == 1) {
         var3 = var1.readUnsignedByte();
         if(var3 > 0) {
            if(this.objectModels != null && !objectCompositionLowDetail) {
               var1.offset += 3 * var3;
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
            if(this.objectModels != null && !objectCompositionLowDetail) {
               var1.offset += 2 * var3;
            } else {
               this.objectTypes = null;
               this.objectModels = new int[var3];

               for(var4 = 0; var4 < var3; ++var4) {
                  this.objectModels[var4] = var1.readUnsignedShort();
               }
            }
         }
      } else if(var2 == 14) {
         this.width = var1.readUnsignedByte();
      } else if(var2 == 15) {
         this.length = var1.readUnsignedByte();
      } else if(var2 == 17) {
         this.clipType = 0;
         this.blocksProjectile = false;
      } else if(var2 == 18) {
         this.blocksProjectile = false;
      } else if(var2 == 19) {
         this.int1 = var1.readUnsignedByte();
      } else if(var2 == 21) {
         this.contouredGround = 0;
      } else if(var2 == 22) {
         this.nonFlatShading = true;
      } else if(var2 == 23) {
         this.modelClipped = true;
      } else if(var2 == 24) {
         this.animationId = var1.readUnsignedShort();
         if(this.animationId == 65535) {
            this.animationId = -1;
         }
      } else if(var2 == 27) {
         this.clipType = 1;
      } else if(var2 == 28) {
         this.decorDisplacement = var1.readUnsignedByte();
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
         this.obstructsGround = true;
      } else if(var2 == 74) {
         this.isHollow = true;
      } else if(var2 == 75) {
         this.supportItems = var1.readUnsignedByte();
      } else if(var2 != 77 && var2 != 92) {
         if(var2 == 78) {
            this.ambientSoundId = var1.readUnsignedShort();
            this.int4 = var1.readUnsignedByte();
         } else if(var2 == 79) {
            this.int5 = var1.readUnsignedShort();
            this.int6 = var1.readUnsignedShort();
            this.int4 = var1.readUnsignedByte();
            var3 = var1.readUnsignedByte();
            this.field3565 = new int[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field3565[var4] = var1.readUnsignedShort();
            }
         } else if(var2 == 81) {
            this.contouredGround = var1.readUnsignedByte() * 256;
         } else if(var2 == 82) {
            this.mapIconId = var1.readUnsignedShort();
         } else if(var2 == 249) {
            this.params = class255.readStringIntParameters(var1, this.params);
         }
      } else {
         this.varpId = var1.readUnsignedShort();
         if(this.varpId == 65535) {
            this.varpId = -1;
         }

         this.configId = var1.readUnsignedShort();
         if(this.configId == 65535) {
            this.configId = -1;
         }

         var3 = -1;
         if(var2 == 92) {
            var3 = var1.readUnsignedShort();
            if(var3 == 65535) {
               var3 = -1;
            }
         }

         var4 = var1.readUnsignedByte();
         this.impostorIds = new int[var4 + 2];

         for(int var5 = 0; var5 <= var4; ++var5) {
            this.impostorIds[var5] = var1.readUnsignedShort();
            if(this.impostorIds[var5] == 65535) {
               this.impostorIds[var5] = -1;
            }
         }

         this.impostorIds[var4 + 1] = var3;
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "2082877841"
   )
   public final boolean method4955(int var1) {
      if(this.objectTypes != null) {
         for(int var4 = 0; var4 < this.objectTypes.length; ++var4) {
            if(this.objectTypes[var4] == var1) {
               return field3518.tryLoadRecord(this.objectModels[var4] & 65535, 0);
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
            var2 &= field3518.tryLoadRecord(this.objectModels[var3] & 65535, 0);
         }

         return var2;
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-126"
   )
   public final boolean method4920() {
      if(this.objectModels == null) {
         return true;
      } else {
         boolean var1 = true;

         for(int var2 = 0; var2 < this.objectModels.length; ++var2) {
            var1 &= field3518.tryLoadRecord(this.objectModels[var2] & 65535, 0);
         }

         return var1;
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(II[[IIIIB)Leh;",
      garbageValue = "-93"
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
            var10.field1712 = (short)(this.ambient + 64);
            var10.contrast = (short)(this.contrast + 768);
            var10.computeNormals();
            var9 = var10;
         }

         cachedModels.put((CacheableNode)var9, var7);
      }

      if(this.nonFlatShading) {
         var9 = ((ModelData)var9).method2630();
      }

      if(this.contouredGround >= 0) {
         if(var9 instanceof Model) {
            var9 = ((Model)var9).method2714(var3, var4, var5, var6, true, this.contouredGround);
         } else if(var9 instanceof ModelData) {
            var9 = ((ModelData)var9).method2627(var3, var4, var5, var6, true, this.contouredGround);
         }
      }

      return (Renderable)var9;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II[[IIIII)Les;",
      garbageValue = "1471114623"
   )
   public final Model method4922(int var1, int var2, int[][] var3, int var4, int var5, int var6) {
      long var7;
      if(this.objectTypes == null) {
         var7 = (long)(var2 + (this.id << 10));
      } else {
         var7 = (long)(var2 + (var1 << 3) + (this.id << 10));
      }

      Model var9 = (Model)field3522.get(var7);
      if(var9 == null) {
         ModelData var10 = this.getModel(var1, var2);
         if(var10 == null) {
            return null;
         }

         var9 = var10.light(this.ambient + 64, this.contrast + 768, -50, -10, -50);
         field3522.put(var9, var7);
      }

      if(this.contouredGround >= 0) {
         var9 = var9.method2714(var3, var4, var5, var6, true, this.contouredGround);
      }

      return var9;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(II[[IIIILje;II)Les;",
      garbageValue = "2001470328"
   )
   public final Model method4940(int var1, int var2, int[][] var3, int var4, int var5, int var6, Sequence var7, int var8) {
      long var9;
      if(this.objectTypes == null) {
         var9 = (long)(var2 + (this.id << 10));
      } else {
         var9 = (long)(var2 + (var1 << 3) + (this.id << 10));
      }

      Model var11 = (Model)field3522.get(var9);
      if(var11 == null) {
         ModelData var12 = this.getModel(var1, var2);
         if(var12 == null) {
            return null;
         }

         var11 = var12.light(this.ambient + 64, this.contrast + 768, -50, -10, -50);
         field3522.put(var11, var9);
      }

      if(var7 == null && this.contouredGround == -1) {
         return var11;
      } else {
         if(var7 != null) {
            var11 = var7.method5080(var11, var8, var2);
         } else {
            var11 = var11.method2737(true);
         }

         if(this.contouredGround >= 0) {
            var11 = var11.method2714(var3, var4, var5, var6, false, this.contouredGround);
         }

         return var11;
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(III)Ldw;",
      garbageValue = "8231299"
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

            var3 = (ModelData)field3520.get((long)var7);
            if(var3 == null) {
               var3 = ModelData.method2620(field3518, var7 & 65535, 0);
               if(var3 == null) {
                  return null;
               }

               if(var4) {
                  var3.method2698();
               }

               field3520.put(var3, (long)var7);
            }

            if(var5 > 1) {
               field3523[var6] = var3;
            }
         }

         if(var5 > 1) {
            var3 = new ModelData(field3523, var5);
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

         var3 = (ModelData)field3520.get((long)var5);
         if(var3 == null) {
            var3 = ModelData.method2620(field3518, var5 & 65535, 0);
            if(var3 == null) {
               return null;
            }

            if(var10) {
               var3.method2698();
            }

            field3520.put(var3, (long)var5);
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
         var8.method2632(256);
         var8.method2633(45, 0, -45);
      }

      var2 &= 3;
      if(var2 == 1) {
         var8.method2679();
      } else if(var2 == 2) {
         var8.method2629();
      } else if(var2 == 3) {
         var8.method2631();
      }

      if(this.recolorToFind != null) {
         for(var7 = 0; var7 < this.recolorToFind.length; ++var7) {
            var8.recolor(this.recolorToFind[var7], this.recolorToReplace[var7]);
         }
      }

      if(this.textureToFind != null) {
         for(var7 = 0; var7 < this.textureToFind.length; ++var7) {
            var8.method2635(this.textureToFind[var7], this.textureToReplace[var7]);
         }
      }

      if(var4) {
         var8.method2622(this.modelSizeX, this.modelSizeHeight, this.modelSizeY);
      }

      if(var11) {
         var8.method2633(this.offsetX, this.offsetHeight, this.offsetY);
      }

      return var8;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)Lju;",
      garbageValue = "8"
   )
   @Export("getImpostor")
   public final ObjectComposition getImpostor() {
      int var1 = -1;
      if(this.varpId != -1) {
         var1 = BoundingBox3DDrawMode.getVarbit(this.varpId);
      } else if(this.configId != -1) {
         var1 = class222.widgetSettings[this.configId];
      }

      int var2;
      if(var1 >= 0 && var1 < this.impostorIds.length - 1) {
         var2 = this.impostorIds[var1];
      } else {
         var2 = this.impostorIds[this.impostorIds.length - 1];
      }

      return var2 != -1?class219.getObjectDefinition(var2):null;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "879546261"
   )
   public int method4926(int var1, int var2) {
      return PendingSpawn.method1591(this.params, var1, var2);
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)Ljava/lang/String;",
      garbageValue = "-978995864"
   )
   public String method4927(int var1, String var2) {
      return IndexData.method4604(this.params, var1, var2);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1850711528"
   )
   public boolean method4928() {
      if(this.impostorIds == null) {
         return this.ambientSoundId != -1 || this.field3565 != null;
      } else {
         for(int var1 = 0; var1 < this.impostorIds.length; ++var1) {
            if(this.impostorIds[var1] != -1) {
               ObjectComposition var2 = class219.getObjectDefinition(this.impostorIds[var1]);
               if(var2.ambientSoundId != -1 || var2.field3565 != null) {
                  return true;
               }
            }
         }

         return false;
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Les;IB)V",
      garbageValue = "31"
   )
   public static final void method4964(Model var0, int var1) {
      for(int var2 = 0; var2 < var0.indicesCount; ++var2) {
         if(var0.field1821[var2] != -2) {
            int var3 = var0.indices1[var2];
            int var4 = var0.indices2[var2];
            int var5 = var0.indices3[var2];
            int var6 = Model.modelViewportYs[var3];
            int var7 = Model.modelViewportYs[var4];
            int var8 = Model.modelViewportYs[var5];
            int var9 = Model.modelViewportXs[var3];
            int var10 = Model.modelViewportXs[var4];
            int var11 = Model.modelViewportXs[var5];
            int var12 = Math.min(var6, Math.min(var7, var8)) - var1;
            int var13 = Math.max(var6, Math.max(var7, var8)) + var1;
            int var14 = Math.min(var9, Math.min(var10, var11)) - var1;
            int var15 = Math.max(var9, Math.max(var10, var11)) + var1;
            class7.boundingBoxes.addFirst(new BoundingBox2D(var12, var14, var13, var15, -49088));
         }
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIIIIZI)Lki;",
      garbageValue = "-1596618183"
   )
   @Export("createSprite")
   public static final SpritePixels createSprite(int var0, int var1, int var2, int var3, int var4, boolean var5) {
      if(var1 == -1) {
         var4 = 0;
      } else if(var4 == 2 && var1 != 1) {
         var4 = 1;
      }

      long var6 = ((long)var3 << 42) + ((long)var2 << 38) + (long)var0 + ((long)var1 << 16) + ((long)var4 << 40);
      SpritePixels var8;
      if(!var5) {
         var8 = (SpritePixels)ItemComposition.itemSpriteCache.get(var6);
         if(var8 != null) {
            return var8;
         }
      }

      ItemComposition var9 = ItemContainer.getItemDefinition(var0);
      if(var1 > 1 && var9.countObj != null) {
         int var10 = -1;

         for(int var11 = 0; var11 < 10; ++var11) {
            if(var1 >= var9.countCo[var11] && var9.countCo[var11] != 0) {
               var10 = var9.countObj[var11];
            }
         }

         if(var10 != -1) {
            var9 = ItemContainer.getItemDefinition(var10);
         }
      }

      Model var19 = var9.getModel(1);
      if(var19 == null) {
         return null;
      } else {
         SpritePixels var20 = null;
         if(var9.notedTemplate != -1) {
            var20 = createSprite(var9.note, 10, 1, 0, 0, true);
            if(var20 == null) {
               return null;
            }
         } else if(var9.notedId != -1) {
            var20 = createSprite(var9.unnotedId, var1, var2, var3, 0, false);
            if(var20 == null) {
               return null;
            }
         } else if(var9.int3 != -1) {
            var20 = createSprite(var9.int2, var1, 0, 0, 0, false);
            if(var20 == null) {
               return null;
            }
         }

         int[] var12 = Rasterizer2D.graphicsPixels;
         int var13 = Rasterizer2D.graphicsPixelsWidth;
         int var14 = Rasterizer2D.graphicsPixelsHeight;
         int[] var15 = new int[4];
         Rasterizer2D.copyDrawRegion(var15);
         var8 = new SpritePixels(36, 32);
         Rasterizer2D.setRasterBuffer(var8.pixels, 36, 32);
         Rasterizer2D.reset();
         Graphics3D.Rasterizer3D_method1();
         Graphics3D.method2820(16, 16);
         Graphics3D.rasterGouraudLowRes = false;
         if(var9.int3 != -1) {
            var20.drawAt(0, 0);
         }

         int var16 = var9.zoom2d;
         if(var5) {
            var16 = (int)(1.5D * (double)var16);
         } else if(var2 == 2) {
            var16 = (int)((double)var16 * 1.04D);
         }

         int var17 = var16 * Graphics3D.SINE[var9.xan2d] >> 16;
         int var18 = var16 * Graphics3D.COSINE[var9.xan2d] >> 16;
         var19.calculateBoundsCylinder();
         var19.method2732(0, var9.yan2d, var9.zan2d, var9.xan2d, var9.offsetX2d, var19.modelHeight / 2 + var17 + var9.offsetY2d, var18 + var9.offsetY2d);
         if(var9.notedId != -1) {
            var20.drawAt(0, 0);
         }

         if(var2 >= 1) {
            var8.method5680(1);
         }

         if(var2 >= 2) {
            var8.method5680(16777215);
         }

         if(var3 != 0) {
            var8.method5693(var3);
         }

         Rasterizer2D.setRasterBuffer(var8.pixels, 36, 32);
         if(var9.notedTemplate != -1) {
            var20.drawAt(0, 0);
         }

         if(var4 == 1 || var4 == 2 && var9.isStackable == 1) {
            MouseRecorder.field793.method5384(class230.getItemStackAmountText(var1), 0, 9, 16776960, 1);
         }

         if(!var5) {
            ItemComposition.itemSpriteCache.put(var8, var6);
         }

         Rasterizer2D.setRasterBuffer(var12, var13, var14);
         Rasterizer2D.setDrawRegion(var15);
         Graphics3D.Rasterizer3D_method1();
         Graphics3D.rasterGouraudLowRes = true;
         return var8;
      }
   }

   @ObfuscatedName("fg")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2109877854"
   )
   static final void method4931() {
      Overlay.overlays.reset();
      FloorUnderlayDefinition.underlays.reset();
      KitDefinition.identKits.reset();
      objects.reset();
      field3520.reset();
      cachedModels.reset();
      field3522.reset();
      NPCComposition.npcs.reset();
      NPCComposition.npcModelCache.reset();
      JagexGame.method4492();
      Sequence.sequences.reset();
      Sequence.skeletons.reset();
      Spotanim.spotanims.reset();
      Spotanim.SpotAnimationDefinition_cachedModels.reset();
      Varbit.varbits.reset();
      class80.method1826();
      Buffer.method3750();
      class218.method4302();
      class263.field3473.reset();
      class262.field3466.reset();
      Area.areaSpriteCache.reset();
      PlayerComposition.field2723.reset();
      GroundObject.method2699();
      ((TextureProvider)Graphics3D.textureLoader).reset();
      Script.field1424.reset();
      class153.indexInterfaces.reset();
      BoundingBox2D.indexSoundEffects.reset();
      class65.indexCache3.reset();
      class62.indexCache4.reset();
      Client.indexMaps.reset();
      class231.indexTrack1.reset();
      class48.indexModels.reset();
      class37.indexSprites.reset();
      class153.indexTextures.reset();
      class65.indexCache10.reset();
      class54.indexTrack2.reset();
      class22.indexScripts.reset();
   }
}
