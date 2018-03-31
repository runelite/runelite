import java.io.File;
import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jj")
@Implements("ObjectComposition")
public class ObjectComposition extends CacheableNode {
   @ObfuscatedName("c")
   @Export("objectCompositionLowDetail")
   public static boolean objectCompositionLowDetail;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Ljm;"
   )
   public static IndexDataBase field3587;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   @Export("objects")
   public static NodeCache objects;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   public static NodeCache field3609;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   @Export("cachedModels")
   public static NodeCache cachedModels;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   public static NodeCache field3591;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "[Ldj;"
   )
   static ModelData[] field3603;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -203768003
   )
   @Export("id")
   public int id;
   @ObfuscatedName("r")
   @Export("objectModels")
   int[] objectModels;
   @ObfuscatedName("d")
   @Export("objectTypes")
   int[] objectTypes;
   @ObfuscatedName("a")
   @Export("name")
   public String name;
   @ObfuscatedName("e")
   @Export("recolorToFind")
   short[] recolorToFind;
   @ObfuscatedName("f")
   @Export("recolorToReplace")
   short[] recolorToReplace;
   @ObfuscatedName("l")
   @Export("textureToFind")
   short[] textureToFind;
   @ObfuscatedName("m")
   @Export("textureToReplace")
   short[] textureToReplace;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 288447891
   )
   @Export("width")
   public int width;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1925031589
   )
   @Export("length")
   public int length;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 275413629
   )
   @Export("clipType")
   public int clipType;
   @ObfuscatedName("v")
   @Export("blocksProjectile")
   public boolean blocksProjectile;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1453940843
   )
   @Export("int1")
   public int int1;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -62075823
   )
   @Export("contouredGround")
   int contouredGround;
   @ObfuscatedName("q")
   @Export("nonFlatShading")
   boolean nonFlatShading;
   @ObfuscatedName("g")
   @Export("modelClipped")
   public boolean modelClipped;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 2049812949
   )
   @Export("animationId")
   public int animationId;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1546385777
   )
   @Export("decorDisplacement")
   public int decorDisplacement;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = -294161495
   )
   @Export("ambient")
   int ambient;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = 1890228519
   )
   @Export("contrast")
   int contrast;
   @ObfuscatedName("al")
   @Export("actions")
   public String[] actions;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = -1780534271
   )
   @Export("mapIconId")
   public int mapIconId;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = 1111180165
   )
   @Export("mapSceneId")
   public int mapSceneId;
   @ObfuscatedName("ak")
   @Export("isRotated")
   boolean isRotated;
   @ObfuscatedName("as")
   @Export("clipped")
   public boolean clipped;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = 830250465
   )
   @Export("modelSizeX")
   int modelSizeX;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = 775283297
   )
   @Export("modelSizeHeight")
   int modelSizeHeight;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -1805969913
   )
   @Export("modelSizeY")
   int modelSizeY;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = 698753105
   )
   @Export("offsetX")
   int offsetX;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = -2077653817
   )
   @Export("offsetHeight")
   int offsetHeight;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 405725635
   )
   @Export("offsetY")
   int offsetY;
   @ObfuscatedName("af")
   @Export("obstructsGround")
   public boolean obstructsGround;
   @ObfuscatedName("aw")
   @Export("isHollow")
   boolean isHollow;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = 680017971
   )
   @Export("supportItems")
   public int supportItems;
   @ObfuscatedName("ag")
   @Export("impostorIds")
   public int[] impostorIds;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = -1391694375
   )
   @Export("varpId")
   int varpId;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = 1560121555
   )
   @Export("configId")
   int configId;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = 219634051
   )
   @Export("ambientSoundId")
   public int ambientSoundId;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = 396245309
   )
   @Export("int4")
   public int int4;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = -511764457
   )
   @Export("int5")
   public int int5;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = -1993750703
   )
   @Export("int6")
   public int int6;
   @ObfuscatedName("ar")
   public int[] field3634;
   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "Lhz;"
   )
   @Export("params")
   IterableHashTable params;

   static {
      objectCompositionLowDetail = false;
      objects = new NodeCache(4096);
      field3609 = new NodeCache(500);
      cachedModels = new NodeCache(30);
      field3591 = new NodeCache(30);
      field3603 = new ModelData[4];
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
      garbageValue = "130936756"
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

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lgp;B)V",
      garbageValue = "0"
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

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lgp;II)V",
      garbageValue = "-754133915"
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
         this.contrast = var1.readByte();
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
            this.field3634 = new int[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field3634[var4] = var1.readUnsignedShort();
            }
         } else if(var2 == 81) {
            this.contouredGround = var1.readUnsignedByte() * 256;
         } else if(var2 == 82) {
            this.mapIconId = var1.readUnsignedShort();
         } else if(var2 == 249) {
            this.params = class245.readStringIntParameters(var1, this.params);
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

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "1757358193"
   )
   public final boolean method5002(int var1) {
      if(this.objectTypes != null) {
         for(int var4 = 0; var4 < this.objectTypes.length; ++var4) {
            if(this.objectTypes[var4] == var1) {
               return field3587.tryLoadRecord(this.objectModels[var4] & 65535, 0);
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
            var2 &= field3587.tryLoadRecord(this.objectModels[var3] & 65535, 0);
         }

         return var2;
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-2021547021"
   )
   public final boolean method5003() {
      if(this.objectModels == null) {
         return true;
      } else {
         boolean var1 = true;

         for(int var2 = 0; var2 < this.objectModels.length; ++var2) {
            var1 &= field3587.tryLoadRecord(this.objectModels[var2] & 65535, 0);
         }

         return var1;
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(II[[IIIII)Lek;",
      garbageValue = "1837930631"
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
            var9 = var10.light(this.ambient + 64, this.contrast * 25 + 768, -50, -10, -50);
         } else {
            var10.field1749 = (short)(this.ambient + 64);
            var10.contrast = (short)(this.contrast * 25 + 768);
            var10.computeNormals();
            var9 = var10;
         }

         cachedModels.put((CacheableNode)var9, var7);
      }

      if(this.nonFlatShading) {
         var9 = ((ModelData)var9).method2587();
      }

      if(this.contouredGround >= 0) {
         if(var9 instanceof Model) {
            var9 = ((Model)var9).method2682(var3, var4, var5, var6, true, this.contouredGround);
         } else if(var9 instanceof ModelData) {
            var9 = ((ModelData)var9).method2588(var3, var4, var5, var6, true, this.contouredGround);
         }
      }

      return (Renderable)var9;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II[[IIIII)Led;",
      garbageValue = "-1080008"
   )
   public final Model method5005(int var1, int var2, int[][] var3, int var4, int var5, int var6) {
      long var7;
      if(this.objectTypes == null) {
         var7 = (long)(var2 + (this.id << 10));
      } else {
         var7 = (long)(var2 + (var1 << 3) + (this.id << 10));
      }

      Model var9 = (Model)field3591.get(var7);
      if(var9 == null) {
         ModelData var10 = this.getModel(var1, var2);
         if(var10 == null) {
            return null;
         }

         var9 = var10.light(this.ambient + 64, this.contrast * 25 + 768, -50, -10, -50);
         field3591.put(var9, var7);
      }

      if(this.contouredGround >= 0) {
         var9 = var9.method2682(var3, var4, var5, var6, true, this.contouredGround);
      }

      return var9;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II[[IIIILkn;II)Led;",
      garbageValue = "-2015399076"
   )
   public final Model method5006(int var1, int var2, int[][] var3, int var4, int var5, int var6, Sequence var7, int var8) {
      long var9;
      if(this.objectTypes == null) {
         var9 = (long)(var2 + (this.id << 10));
      } else {
         var9 = (long)(var2 + (var1 << 3) + (this.id << 10));
      }

      Model var11 = (Model)field3591.get(var9);
      if(var11 == null) {
         ModelData var12 = this.getModel(var1, var2);
         if(var12 == null) {
            return null;
         }

         var11 = var12.light(this.ambient + 64, this.contrast * 25 + 768, -50, -10, -50);
         field3591.put(var11, var9);
      }

      if(var7 == null && this.contouredGround == -1) {
         return var11;
      } else {
         if(var7 != null) {
            var11 = var7.transformObjectModel(var11, var8, var2);
         } else {
            var11 = var11.toSharedModel(true);
         }

         if(this.contouredGround >= 0) {
            var11 = var11.method2682(var3, var4, var5, var6, false, this.contouredGround);
         }

         return var11;
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(III)Ldj;",
      garbageValue = "979763817"
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

            var3 = (ModelData)field3609.get((long)var7);
            if(var3 == null) {
               var3 = ModelData.method2583(field3587, var7 & 65535, 0);
               if(var3 == null) {
                  return null;
               }

               if(var4) {
                  var3.method2626();
               }

               field3609.put(var3, (long)var7);
            }

            if(var5 > 1) {
               field3603[var6] = var3;
            }
         }

         if(var5 > 1) {
            var3 = new ModelData(field3603, var5);
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

         var3 = (ModelData)field3609.get((long)var5);
         if(var3 == null) {
            var3 = ModelData.method2583(field3587, var5 & 65535, 0);
            if(var3 == null) {
               return null;
            }

            if(var10) {
               var3.method2626();
            }

            field3609.put(var3, (long)var5);
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

      ModelData var8 = new ModelData(var3, var2 == 0 && !var4 && !var11, null == this.recolorToFind, null == this.textureToFind, true);
      if(var1 == 4 && var2 > 3) {
         var8.method2593(256);
         var8.method2647(45, 0, -45);
      }

      var2 &= 3;
      if(var2 == 1) {
         var8.method2590();
      } else if(var2 == 2) {
         var8.method2591();
      } else if(var2 == 3) {
         var8.method2592();
      }

      if(this.recolorToFind != null) {
         for(var7 = 0; var7 < this.recolorToFind.length; ++var7) {
            var8.recolor(this.recolorToFind[var7], this.recolorToReplace[var7]);
         }
      }

      if(this.textureToFind != null) {
         for(var7 = 0; var7 < this.textureToFind.length; ++var7) {
            var8.method2660(this.textureToFind[var7], this.textureToReplace[var7]);
         }
      }

      if(var4) {
         var8.method2644(this.modelSizeX, this.modelSizeHeight, this.modelSizeY);
      }

      if(var11) {
         var8.method2647(this.offsetX, this.offsetHeight, this.offsetY);
      }

      return var8;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)Ljj;",
      garbageValue = "-38"
   )
   @Export("getImpostor")
   public final ObjectComposition getImpostor() {
      int var1 = -1;
      if(this.varpId != -1) {
         var1 = class88.getVarbit(this.varpId);
      } else if(this.configId != -1) {
         var1 = class237.clientVarps[this.configId];
      }

      int var2;
      if(var1 >= 0 && var1 < this.impostorIds.length - 1) {
         var2 = this.impostorIds[var1];
      } else {
         var2 = this.impostorIds[this.impostorIds.length - 1];
      }

      return var2 != -1?FileRequest.getObjectDefinition(var2):null;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "1"
   )
   public int method5009(int var1, int var2) {
      return class23.method190(this.params, var1, var2);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;B)Ljava/lang/String;",
      garbageValue = "10"
   )
   public String method5010(int var1, String var2) {
      return class155.method3172(this.params, var1, var2);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-37"
   )
   public boolean method5011() {
      if(this.impostorIds == null) {
         return this.ambientSoundId != -1 || this.field3634 != null;
      } else {
         for(int var1 = 0; var1 < this.impostorIds.length; ++var1) {
            if(this.impostorIds[var1] != -1) {
               ObjectComposition var2 = FileRequest.getObjectDefinition(this.impostorIds[var1]);
               if(var2.ambientSoundId != -1 || var2.field3634 != null) {
                  return true;
               }
            }
         }

         return false;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/io/File;Ljava/io/File;B)V",
      garbageValue = "-6"
   )
   static void method5052(File var0, File var1) {
      try {
         FileOnDisk var2 = new FileOnDisk(class167.jagexClDat, "rw", 10000L);
         Buffer var3 = new Buffer(500);
         var3.putByte(3);
         var3.putByte(var1 != null?1:0);
         var3.putCESU8(var0.getPath());
         if(var1 != null) {
            var3.putCESU8("");
         }

         var2.write(var3.payload, 0, var3.offset);
         var2.close();
      } catch (IOException var4) {
         var4.printStackTrace();
      }

   }
}
