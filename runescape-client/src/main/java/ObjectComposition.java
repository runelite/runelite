import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("je")
@Implements("ObjectComposition")
public class ObjectComposition extends CacheableNode {
   @ObfuscatedName("t")
   @Export("objectCompositionLowDetail")
   static boolean objectCompositionLowDetail;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Ljc;"
   )
   @Export("objects_ref")
   static IndexDataBase objects_ref;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   @Export("objects")
   public static NodeCache objects;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   public static NodeCache field3597;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   @Export("cachedModels")
   public static NodeCache cachedModels;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   public static NodeCache field3599;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "[Ldi;"
   )
   static ModelData[] field3600;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -842687417
   )
   @Export("id")
   public int id;
   @ObfuscatedName("g")
   @Export("objectModels")
   int[] objectModels;
   @ObfuscatedName("n")
   @Export("objectTypes")
   int[] objectTypes;
   @ObfuscatedName("o")
   @Export("name")
   public String name;
   @ObfuscatedName("c")
   @Export("recolorToFind")
   short[] recolorToFind;
   @ObfuscatedName("v")
   @Export("recolorToReplace")
   short[] recolorToReplace;
   @ObfuscatedName("u")
   @Export("textureToFind")
   short[] textureToFind;
   @ObfuscatedName("j")
   @Export("textureToReplace")
   short[] textureToReplace;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 768700099
   )
   @Export("width")
   public int width;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1278775147
   )
   @Export("length")
   public int length;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -404119069
   )
   @Export("clipType")
   public int clipType;
   @ObfuscatedName("s")
   @Export("blocksProjectile")
   public boolean blocksProjectile;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -679410545
   )
   @Export("int1")
   public int int1;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -918718619
   )
   @Export("contouredGround")
   int contouredGround;
   @ObfuscatedName("r")
   @Export("nonFlatShading")
   boolean nonFlatShading;
   @ObfuscatedName("y")
   @Export("modelClipped")
   public boolean modelClipped;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 240236025
   )
   @Export("animationId")
   public int animationId;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -216681433
   )
   @Export("decorDisplacement")
   public int decorDisplacement;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = 1652492905
   )
   @Export("ambient")
   int ambient;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -1957207715
   )
   @Export("contrast")
   int contrast;
   @ObfuscatedName("av")
   @Export("actions")
   public String[] actions;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = 644236959
   )
   @Export("mapIconId")
   public int mapIconId;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = -758809621
   )
   @Export("mapSceneId")
   public int mapSceneId;
   @ObfuscatedName("am")
   @Export("isRotated")
   boolean isRotated;
   @ObfuscatedName("az")
   @Export("clipped")
   public boolean clipped;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = -1820328363
   )
   @Export("modelSizeX")
   int modelSizeX;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = 133250809
   )
   @Export("modelSizeHeight")
   int modelSizeHeight;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = 124548847
   )
   @Export("modelSizeY")
   int modelSizeY;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -1635836265
   )
   @Export("offsetX")
   int offsetX;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = -1395625125
   )
   @Export("offsetHeight")
   int offsetHeight;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = -1035050829
   )
   @Export("offsetY")
   int offsetY;
   @ObfuscatedName("ai")
   @Export("obstructsGround")
   public boolean obstructsGround;
   @ObfuscatedName("al")
   @Export("isHollow")
   boolean isHollow;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = 63290501
   )
   @Export("supportItems")
   public int supportItems;
   @ObfuscatedName("ag")
   @Export("impostorIds")
   public int[] impostorIds;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = -591302887
   )
   @Export("varpId")
   int varpId;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = 20833125
   )
   @Export("configId")
   int configId;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = -1930710191
   )
   @Export("ambientSoundId")
   public int ambientSoundId;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = -1763473263
   )
   @Export("int4")
   public int int4;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = 1078581891
   )
   @Export("int5")
   public int int5;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = -835661127
   )
   @Export("int6")
   public int int6;
   @ObfuscatedName("ab")
   public int[] field3642;
   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "Lhq;"
   )
   @Export("params")
   IterableHashTable params;

   static {
      objectCompositionLowDetail = false;
      objects = new NodeCache(4096);
      field3597 = new NodeCache(500);
      cachedModels = new NodeCache(30);
      field3599 = new NodeCache(30);
      field3600 = new ModelData[4];
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

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1856089620"
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

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lgb;I)V",
      garbageValue = "120730341"
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

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lgb;IB)V",
      garbageValue = "1"
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
            this.field3642 = new int[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field3642[var4] = var1.readUnsignedShort();
            }
         } else if(var2 == 81) {
            this.contouredGround = var1.readUnsignedByte() * 256;
         } else if(var2 == 82) {
            this.mapIconId = var1.readUnsignedShort();
         } else if(var2 == 249) {
            this.params = class2.readStringIntParameters(var1, this.params);
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

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-1289064119"
   )
   public final boolean method5025(int var1) {
      if(this.objectTypes != null) {
         for(int var4 = 0; var4 < this.objectTypes.length; ++var4) {
            if(this.objectTypes[var4] == var1) {
               return class21.field315.tryLoadRecord(this.objectModels[var4] & 65535, 0);
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
            var2 &= class21.field315.tryLoadRecord(this.objectModels[var3] & 65535, 0);
         }

         return var2;
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-874269186"
   )
   public final boolean method4992() {
      if(this.objectModels == null) {
         return true;
      } else {
         boolean var1 = true;

         for(int var2 = 0; var2 < this.objectModels.length; ++var2) {
            var1 &= class21.field315.tryLoadRecord(this.objectModels[var2] & 65535, 0);
         }

         return var1;
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II[[IIIIB)Len;",
      garbageValue = "-50"
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
            var10.field1730 = (short)(this.ambient + 64);
            var10.contrast = (short)(this.contrast + 768);
            var10.computeNormals();
            var9 = var10;
         }

         cachedModels.put((CacheableNode)var9, var7);
      }

      if(this.nonFlatShading) {
         var9 = ((ModelData)var9).method2593();
      }

      if(this.contouredGround >= 0) {
         if(var9 instanceof Model) {
            var9 = ((Model)var9).method2685(var3, var4, var5, var6, true, this.contouredGround);
         } else if(var9 instanceof ModelData) {
            var9 = ((ModelData)var9).method2661(var3, var4, var5, var6, true, this.contouredGround);
         }
      }

      return (Renderable)var9;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II[[IIIII)Lek;",
      garbageValue = "751473866"
   )
   public final Model method5024(int var1, int var2, int[][] var3, int var4, int var5, int var6) {
      long var7;
      if(this.objectTypes == null) {
         var7 = (long)(var2 + (this.id << 10));
      } else {
         var7 = (long)(var2 + (var1 << 3) + (this.id << 10));
      }

      Model var9 = (Model)field3599.get(var7);
      if(var9 == null) {
         ModelData var10 = this.getModel(var1, var2);
         if(var10 == null) {
            return null;
         }

         var9 = var10.light(this.ambient + 64, this.contrast + 768, -50, -10, -50);
         field3599.put(var9, var7);
      }

      if(this.contouredGround >= 0) {
         var9 = var9.method2685(var3, var4, var5, var6, true, this.contouredGround);
      }

      return var9;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(II[[IIIILkf;II)Lek;",
      garbageValue = "-546189586"
   )
   public final Model method5000(int var1, int var2, int[][] var3, int var4, int var5, int var6, Sequence var7, int var8) {
      long var9;
      if(this.objectTypes == null) {
         var9 = (long)(var2 + (this.id << 10));
      } else {
         var9 = (long)(var2 + (var1 << 3) + (this.id << 10));
      }

      Model var11 = (Model)field3599.get(var9);
      if(var11 == null) {
         ModelData var12 = this.getModel(var1, var2);
         if(var12 == null) {
            return null;
         }

         var11 = var12.light(this.ambient + 64, this.contrast + 768, -50, -10, -50);
         field3599.put(var11, var9);
      }

      if(var7 == null && this.contouredGround == -1) {
         return var11;
      } else {
         if(var7 != null) {
            var11 = var7.method5185(var11, var8, var2);
         } else {
            var11 = var11.method2686(true);
         }

         if(this.contouredGround >= 0) {
            var11 = var11.method2685(var3, var4, var5, var6, false, this.contouredGround);
         }

         return var11;
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(III)Ldi;",
      garbageValue = "601657225"
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

            var3 = (ModelData)field3597.get((long)var7);
            if(var3 == null) {
               var3 = ModelData.method2594(class21.field315, var7 & 65535, 0);
               if(var3 == null) {
                  return null;
               }

               if(var4) {
                  var3.method2616();
               }

               field3597.put(var3, (long)var7);
            }

            if(var5 > 1) {
               field3600[var6] = var3;
            }
         }

         if(var5 > 1) {
            var3 = new ModelData(field3600, var5);
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

         var3 = (ModelData)field3597.get((long)var5);
         if(var3 == null) {
            var3 = ModelData.method2594(class21.field315, var5 & 65535, 0);
            if(var3 == null) {
               return null;
            }

            if(var10) {
               var3.method2616();
            }

            field3597.put(var3, (long)var5);
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
         var8.method2600(256);
         var8.method2607(45, 0, -45);
      }

      var2 &= 3;
      if(var2 == 1) {
         var8.method2603();
      } else if(var2 == 2) {
         var8.method2604();
      } else if(var2 == 3) {
         var8.method2665();
      }

      if(this.recolorToFind != null) {
         for(var7 = 0; var7 < this.recolorToFind.length; ++var7) {
            var8.recolor(this.recolorToFind[var7], this.recolorToReplace[var7]);
         }
      }

      if(this.textureToFind != null) {
         for(var7 = 0; var7 < this.textureToFind.length; ++var7) {
            var8.method2609(this.textureToFind[var7], this.textureToReplace[var7]);
         }
      }

      if(var4) {
         var8.method2610(this.modelSizeX, this.modelSizeHeight, this.modelSizeY);
      }

      if(var11) {
         var8.method2607(this.offsetX, this.offsetHeight, this.offsetY);
      }

      return var8;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)Lje;",
      garbageValue = "0"
   )
   @Export("getImpostor")
   public final ObjectComposition getImpostor() {
      int var1 = -1;
      if(this.varpId != -1) {
         var1 = World.getVarbit(this.varpId);
      } else if(this.configId != -1) {
         var1 = class237.widgetSettings[this.configId];
      }

      int var2;
      if(var1 >= 0 && var1 < this.impostorIds.length - 1) {
         var2 = this.impostorIds[var1];
      } else {
         var2 = this.impostorIds[this.impostorIds.length - 1];
      }

      return var2 != -1?Spotanim.getObjectDefinition(var2):null;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "589971710"
   )
   public int method4998(int var1, int var2) {
      return class297.method5284(this.params, var1, var2);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)Ljava/lang/String;",
      garbageValue = "-1862333596"
   )
   public String method4991(int var1, String var2) {
      IterableHashTable var4 = this.params;
      String var3;
      if(var4 == null) {
         var3 = var2;
      } else {
         ObjectNode var5 = (ObjectNode)var4.get((long)var1);
         if(var5 == null) {
            var3 = var2;
         } else {
            var3 = (String)var5.value;
         }
      }

      return var3;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "151396871"
   )
   public boolean method5008() {
      if(this.impostorIds == null) {
         return this.ambientSoundId != -1 || this.field3642 != null;
      } else {
         for(int var1 = 0; var1 < this.impostorIds.length; ++var1) {
            if(this.impostorIds[var1] != -1) {
               ObjectComposition var2 = Spotanim.getObjectDefinition(this.impostorIds[var1]);
               if(var2.ambientSoundId != -1 || var2.field3642 != null) {
                  return true;
               }
            }
         }

         return false;
      }
   }
}
