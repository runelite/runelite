import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ji")
@Implements("ObjectComposition")
public class ObjectComposition extends CacheableNode {
   @ObfuscatedName("n")
   @Export("ObjectDefinition_isLowDetail")
   static boolean ObjectDefinition_isLowDetail;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lil;"
   )
   @Export("objects_ref")
   static IndexDataBase objects_ref;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lil;"
   )
   static IndexDataBase field3522;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lga;"
   )
   @Export("objects")
   static NodeCache objects;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lga;"
   )
   public static NodeCache field3524;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lga;"
   )
   @Export("cachedModels")
   static NodeCache cachedModels;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lga;"
   )
   static NodeCache field3552;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "[Ldh;"
   )
   static ModelData[] field3527;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1214822967
   )
   @Export("id")
   public int id;
   @ObfuscatedName("f")
   @Export("objectModels")
   int[] objectModels;
   @ObfuscatedName("z")
   @Export("objectTypes")
   int[] objectTypes;
   @ObfuscatedName("u")
   @Export("name")
   public String name;
   @ObfuscatedName("p")
   @Export("recolorToFind")
   short[] recolorToFind;
   @ObfuscatedName("w")
   @Export("recolorToReplace")
   short[] recolorToReplace;
   @ObfuscatedName("t")
   @Export("textureToFind")
   short[] textureToFind;
   @ObfuscatedName("o")
   @Export("textureToReplace")
   short[] textureToReplace;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1423927001
   )
   @Export("width")
   public int width;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1893629857
   )
   @Export("length")
   public int length;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1342103707
   )
   @Export("clipType")
   public int clipType;
   @ObfuscatedName("x")
   @Export("blocksProjectile")
   public boolean blocksProjectile;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1390443309
   )
   @Export("int1")
   public int int1;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 623363405
   )
   @Export("contouredGround")
   int contouredGround;
   @ObfuscatedName("g")
   @Export("nonFlatShading")
   boolean nonFlatShading;
   @ObfuscatedName("c")
   @Export("modelClipped")
   public boolean modelClipped;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -17869461
   )
   @Export("animationId")
   public int animationId;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 478298465
   )
   @Export("decorDisplacement")
   public int decorDisplacement;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = -1188483619
   )
   @Export("ambient")
   int ambient;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = -1054225147
   )
   @Export("contrast")
   int contrast;
   @ObfuscatedName("at")
   @Export("actions")
   public String[] actions;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = -1996116985
   )
   @Export("mapIconId")
   public int mapIconId;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = -1643523835
   )
   @Export("mapSceneId")
   public int mapSceneId;
   @ObfuscatedName("af")
   @Export("isRotated")
   boolean isRotated;
   @ObfuscatedName("az")
   @Export("clipped")
   public boolean clipped;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = -1199209541
   )
   @Export("modelSizeX")
   int modelSizeX;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = 24045283
   )
   @Export("modelSizeHeight")
   int modelSizeHeight;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = 175239069
   )
   @Export("modelSizeY")
   int modelSizeY;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = 461989129
   )
   @Export("offsetX")
   int offsetX;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = -95873567
   )
   @Export("offsetHeight")
   int offsetHeight;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = -741504479
   )
   @Export("offsetY")
   int offsetY;
   @ObfuscatedName("aj")
   @Export("obstructsGround")
   public boolean obstructsGround;
   @ObfuscatedName("aa")
   @Export("isHollow")
   boolean isHollow;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = 1050482093
   )
   @Export("supportItems")
   public int supportItems;
   @ObfuscatedName("al")
   @Export("impostorIds")
   public int[] impostorIds;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = -1985913491
   )
   @Export("varpId")
   int varpId;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = 150368401
   )
   @Export("configId")
   int configId;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = -650599853
   )
   @Export("ambientSoundId")
   public int ambientSoundId;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = 1353914647
   )
   @Export("int4")
   public int int4;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = -1421091489
   )
   @Export("int5")
   public int int5;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = -1016751483
   )
   @Export("int6")
   public int int6;
   @ObfuscatedName("ai")
   public int[] field3569;
   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "Lgb;"
   )
   @Export("params")
   IterableHashTable params;

   static {
      ObjectDefinition_isLowDetail = false;
      objects = new NodeCache(4096);
      field3524 = new NodeCache(500);
      cachedModels = new NodeCache(30);
      field3552 = new NodeCache(30);
      field3527 = new ModelData[4];
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

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-105"
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

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lgv;B)V",
      garbageValue = "-8"
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
      signature = "(Lgv;II)V",
      garbageValue = "-982470053"
   )
   @Export("loadData")
   void loadData(Buffer var1, int var2) {
      int var3;
      int var4;
      if(var2 == 1) {
         var3 = var1.readUnsignedByte();
         if(var3 > 0) {
            if(this.objectModels != null && !ObjectDefinition_isLowDetail) {
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
            if(this.objectModels != null && !ObjectDefinition_isLowDetail) {
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
            this.field3569 = new int[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field3569[var4] = var1.readUnsignedShort();
            }
         } else if(var2 == 81) {
            this.contouredGround = var1.readUnsignedByte() * 256;
         } else if(var2 == 82) {
            this.mapIconId = var1.readUnsignedShort();
         } else if(var2 == 249) {
            this.params = class18.readStringIntParameters(var1, this.params);
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

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "708206654"
   )
   public final boolean method4708(int var1) {
      if(this.objectTypes != null) {
         for(int var4 = 0; var4 < this.objectTypes.length; ++var4) {
            if(this.objectTypes[var4] == var1) {
               return field3522.tryLoadRecord(this.objectModels[var4] & 65535, 0);
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
            var2 &= field3522.tryLoadRecord(this.objectModels[var3] & 65535, 0);
         }

         return var2;
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1745735746"
   )
   public final boolean method4709() {
      if(this.objectModels == null) {
         return true;
      } else {
         boolean var1 = true;

         for(int var2 = 0; var2 < this.objectModels.length; ++var2) {
            var1 &= field3522.tryLoadRecord(this.objectModels[var2] & 65535, 0);
         }

         return var1;
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(II[[IIIII)Leo;",
      garbageValue = "-1420852540"
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
            var10.field1734 = (short)(this.ambient + 64);
            var10.contrast = (short)(this.contrast + 768);
            var10.computeNormals();
            var9 = var10;
         }

         cachedModels.put((CacheableNode)var9, var7);
      }

      if(this.nonFlatShading) {
         var9 = ((ModelData)var9).method2477();
      }

      if(this.contouredGround >= 0) {
         if(var9 instanceof Model) {
            var9 = ((Model)var9).method2573(var3, var4, var5, var6, true, this.contouredGround);
         } else if(var9 instanceof ModelData) {
            var9 = ((ModelData)var9).method2478(var3, var4, var5, var6, true, this.contouredGround);
         }
      }

      return (Renderable)var9;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II[[IIIIB)Les;",
      garbageValue = "85"
   )
   public final Model method4711(int var1, int var2, int[][] var3, int var4, int var5, int var6) {
      long var7;
      if(this.objectTypes == null) {
         var7 = (long)(var2 + (this.id << 10));
      } else {
         var7 = (long)(var2 + (var1 << 3) + (this.id << 10));
      }

      Model var9 = (Model)field3552.get(var7);
      if(var9 == null) {
         ModelData var10 = this.getModel(var1, var2);
         if(var10 == null) {
            return null;
         }

         var9 = var10.light(this.ambient + 64, this.contrast + 768, -50, -10, -50);
         field3552.put(var9, var7);
      }

      if(this.contouredGround >= 0) {
         var9 = var9.method2573(var3, var4, var5, var6, true, this.contouredGround);
      }

      return var9;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II[[IIIILjs;II)Les;",
      garbageValue = "1553638675"
   )
   public final Model method4712(int var1, int var2, int[][] var3, int var4, int var5, int var6, Sequence var7, int var8) {
      long var9;
      if(this.objectTypes == null) {
         var9 = (long)(var2 + (this.id << 10));
      } else {
         var9 = (long)(var2 + (var1 << 3) + (this.id << 10));
      }

      Model var11 = (Model)field3552.get(var9);
      if(var11 == null) {
         ModelData var12 = this.getModel(var1, var2);
         if(var12 == null) {
            return null;
         }

         var11 = var12.light(this.ambient + 64, this.contrast + 768, -50, -10, -50);
         field3552.put(var11, var9);
      }

      if(var7 == null && this.contouredGround == -1) {
         return var11;
      } else {
         if(var7 != null) {
            var11 = var7.method4899(var11, var8, var2);
         } else {
            var11 = var11.method2584(true);
         }

         if(this.contouredGround >= 0) {
            var11 = var11.method2573(var3, var4, var5, var6, false, this.contouredGround);
         }

         return var11;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(III)Ldh;",
      garbageValue = "279929416"
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

            var3 = (ModelData)field3524.get((long)var7);
            if(var3 == null) {
               var3 = ModelData.method2483(field3522, var7 & 65535, 0);
               if(var3 == null) {
                  return null;
               }

               if(var4) {
                  var3.method2487();
               }

               field3524.put(var3, (long)var7);
            }

            if(var5 > 1) {
               field3527[var6] = var3;
            }
         }

         if(var5 > 1) {
            var3 = new ModelData(field3527, var5);
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

         var3 = (ModelData)field3524.get((long)var5);
         if(var3 == null) {
            var3 = ModelData.method2483(field3522, var5 & 65535, 0);
            if(var3 == null) {
               return null;
            }

            if(var10) {
               var3.method2487();
            }

            field3524.put(var3, (long)var5);
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
         var8.method2511(256);
         var8.method2504(45, 0, -45);
      }

      var2 &= 3;
      if(var2 == 1) {
         var8.method2480();
      } else if(var2 == 2) {
         var8.method2481();
      } else if(var2 == 3) {
         var8.method2482();
      }

      if(this.recolorToFind != null) {
         for(var7 = 0; var7 < this.recolorToFind.length; ++var7) {
            var8.recolor(this.recolorToFind[var7], this.recolorToReplace[var7]);
         }
      }

      if(this.textureToFind != null) {
         for(var7 = 0; var7 < this.textureToFind.length; ++var7) {
            var8.method2486(this.textureToFind[var7], this.textureToReplace[var7]);
         }
      }

      if(var4) {
         var8.method2488(this.modelSizeX, this.modelSizeHeight, this.modelSizeY);
      }

      if(var11) {
         var8.method2504(this.offsetX, this.offsetHeight, this.offsetY);
      }

      return var8;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)Lji;",
      garbageValue = "528428728"
   )
   @Export("getImpostor")
   public final ObjectComposition getImpostor() {
      int var1 = -1;
      if(this.varpId != -1) {
         var1 = PendingSpawn.getVarbit(this.varpId);
      } else if(this.configId != -1) {
         var1 = class222.widgetSettings[this.configId];
      }

      int var2;
      if(var1 >= 0 && var1 < this.impostorIds.length - 1) {
         var2 = this.impostorIds[var1];
      } else {
         var2 = this.impostorIds[this.impostorIds.length - 1];
      }

      return var2 != -1?NPC.getObjectDefinition(var2):null;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-487939213"
   )
   public int method4757(int var1, int var2) {
      return GrandExchangeOffer.method113(this.params, var1, var2);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)Ljava/lang/String;",
      garbageValue = "47154201"
   )
   public String method4716(int var1, String var2) {
      return class239.method4279(this.params, var1, var2);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "304619302"
   )
   public boolean method4742() {
      if(this.impostorIds == null) {
         return this.ambientSoundId != -1 || this.field3569 != null;
      } else {
         for(int var1 = 0; var1 < this.impostorIds.length; ++var1) {
            if(this.impostorIds[var1] != -1) {
               ObjectComposition var2 = NPC.getObjectDefinition(this.impostorIds[var1]);
               if(var2.ambientSoundId != -1 || var2.field3569 != null) {
                  return true;
               }
            }
         }

         return false;
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)Ljava/lang/String;",
      garbageValue = "1982987970"
   )
   public static String method4725(CharSequence var0) {
      int var1 = var0.length();
      StringBuilder var2 = new StringBuilder(var1);

      for(int var3 = 0; var3 < var1; ++var3) {
         char var4 = var0.charAt(var3);
         if((var4 < 'a' || var4 > 'z') && (var4 < 'A' || var4 > 'Z') && (var4 < '0' || var4 > '9') && var4 != '.' && var4 != '-' && var4 != '*' && var4 != '_') {
            if(var4 == ' ') {
               var2.append('+');
            } else {
               byte var5 = PacketBuffer.charToByteCp1252(var4);
               var2.append('%');
               int var6 = var5 >> 4 & 15;
               if(var6 >= 10) {
                  var2.append((char)(var6 + 55));
               } else {
                  var2.append((char)(var6 + 48));
               }

               var6 = var5 & 15;
               if(var6 >= 10) {
                  var2.append((char)(var6 + 55));
               } else {
                  var2.append((char)(var6 + 48));
               }
            }
         } else {
            var2.append(var4);
         }
      }

      return var2.toString();
   }
}
