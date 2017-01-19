import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gg")
@Implements("ObjectComposition")
public class ObjectComposition extends CacheableNode {
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = -2004632509
   )
   @Export("offsetX")
   int offsetX = 0;
   @ObfuscatedName("aq")
   @Export("isSolid")
   boolean isSolid = false;
   @ObfuscatedName("a")
   public static NodeCache field2902 = new NodeCache(500);
   @ObfuscatedName("g")
   public static NodeCache field2903 = new NodeCache(30);
   @ObfuscatedName("as")
   public boolean field2904 = false;
   @ObfuscatedName("u")
   static ModelData[] field2905 = new ModelData[4];
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = -62671035
   )
   @Export("mapIconId")
   public int mapIconId = -1;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = 1126878457
   )
   @Export("mapSceneId")
   public int mapSceneId = -1;
   @ObfuscatedName("r")
   @Export("objectTypes")
   int[] objectTypes;
   @ObfuscatedName("n")
   @Export("name")
   public String name = "null";
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 782303241
   )
   public int field2910 = -1;
   @ObfuscatedName("j")
   @Export("recolorToReplace")
   short[] recolorToReplace;
   @ObfuscatedName("w")
   @Export("textureToFind")
   short[] textureToFind;
   @ObfuscatedName("p")
   @Export("textureToReplace")
   short[] textureToReplace;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -734180527
   )
   @Export("sizeX")
   public int sizeX = 1;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1320879725
   )
   @Export("sizeY")
   public int sizeY = 1;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -2142727307
   )
   public int field2916 = 2;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = -1623715647
   )
   @Export("modelSizeY")
   int modelSizeY = 128;
   @ObfuscatedName("c")
   public static class182 field2918;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 820990521
   )
   int field2919 = -1;
   @ObfuscatedName("q")
   @Export("nonFlatShading")
   boolean nonFlatShading = false;
   @ObfuscatedName("y")
   public boolean field2921 = false;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1750609283
   )
   @Export("animationId")
   public int animationId = -1;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1708942571
   )
   public int field2923 = 16;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = 2146710019
   )
   @Export("ambient")
   int ambient = 0;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = -204222553
   )
   @Export("contrast")
   int contrast = 0;
   @ObfuscatedName("ad")
   @Export("actions")
   public String[] actions = new String[5];
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = -82600765
   )
   @Export("configId")
   int configId = -1;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = -2029786485
   )
   @Export("modelSizeX")
   int modelSizeX = 128;
   @ObfuscatedName("ax")
   boolean field2929 = false;
   @ObfuscatedName("ae")
   public boolean field2930 = true;
   @ObfuscatedName("h")
   public static NodeCache field2931 = new NodeCache(64);
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = -2144495343
   )
   @Export("modelSizeHeight")
   int modelSizeHeight = 128;
   @ObfuscatedName("e")
   public boolean field2933 = true;
   @ObfuscatedName("s")
   public static boolean field2934 = false;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = -7553867
   )
   @Export("offsetHeight")
   int offsetHeight = 0;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = 1726691677
   )
   @Export("offsetY")
   int offsetY = 0;
   @ObfuscatedName("au")
   public int[] field2937;
   @ObfuscatedName("aj")
   @Export("impostorIds")
   public int[] impostorIds;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = 410505717
   )
   public int field2939 = -1;
   @ObfuscatedName("k")
   public static NodeCache field2940 = new NodeCache(30);
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = -1057842367
   )
   @Export("varpId")
   int varpId = -1;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1571726999
   )
   public int field2942;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = 1541687385
   )
   @Export("ambientSoundId")
   public int ambientSoundId = -1;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = 1040975779
   )
   public int field2944 = 0;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = 997536097
   )
   public int field2945 = 0;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = -801610033
   )
   public int field2946 = 0;
   @ObfuscatedName("m")
   @Export("recolorToFind")
   short[] recolorToFind;
   @ObfuscatedName("x")
   @Export("objectModels")
   int[] objectModels;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "105"
   )
   void method3483(Buffer var1) {
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
      signature = "(LBuffer;II)V",
      garbageValue = "1743519873"
   )
   @Export("loadData")
   void loadData(Buffer var1, int var2) {
      int var3;
      int var4;
      if(var2 == 1) {
         var3 = var1.readUnsignedByte();
         if(var3 > 0) {
            if(this.objectModels != null && !field2934) {
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
         this.name = var1.method2911();
      } else if(var2 == 5) {
         var3 = var1.readUnsignedByte();
         if(var3 > 0) {
            if(null != this.objectModels && !field2934) {
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
         this.sizeX = var1.readUnsignedByte();
      } else if(var2 == 15) {
         this.sizeY = var1.readUnsignedByte();
      } else if(var2 == 17) {
         this.field2916 = 0;
         this.field2933 = false;
      } else if(var2 == 18) {
         this.field2933 = false;
      } else if(var2 == 19) {
         this.field2910 = var1.readUnsignedByte();
      } else if(var2 == 21) {
         this.field2919 = 0;
      } else if(var2 == 22) {
         this.nonFlatShading = true;
      } else if(var2 == 23) {
         this.field2921 = true;
      } else if(var2 == 24) {
         this.animationId = var1.readUnsignedShort();
         if(this.animationId == '\uffff') {
            this.animationId = -1;
         }
      } else if(var2 == 27) {
         this.field2916 = 1;
      } else if(var2 == 28) {
         this.field2923 = var1.readUnsignedByte();
      } else if(var2 == 29) {
         this.ambient = var1.readByte();
      } else if(var2 == 39) {
         this.contrast = var1.readByte() * 25;
      } else if(var2 >= 30 && var2 < 35) {
         this.actions[var2 - 30] = var1.method2911();
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
      } else if(var2 == 60) {
         this.mapIconId = var1.readUnsignedShort();
      } else if(var2 == 62) {
         this.field2929 = true;
      } else if(var2 == 64) {
         this.field2930 = false;
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
         this.field2904 = true;
      } else if(var2 == 74) {
         this.isSolid = true;
      } else if(var2 == 75) {
         this.field2939 = var1.readUnsignedByte();
      } else if(var2 != 77 && var2 != 92) {
         if(var2 == 78) {
            this.ambientSoundId = var1.readUnsignedShort();
            this.field2944 = var1.readUnsignedByte();
         } else if(var2 == 79) {
            this.field2945 = var1.readUnsignedShort();
            this.field2946 = var1.readUnsignedShort();
            this.field2944 = var1.readUnsignedByte();
            var3 = var1.readUnsignedByte();
            this.field2937 = new int[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field2937[var4] = var1.readUnsignedShort();
            }
         } else if(var2 == 81) {
            this.field2919 = var1.readUnsignedByte() * 256;
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

         this.impostorIds[1 + var4] = var3;
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "7"
   )
   public final boolean method3485(int var1) {
      if(null != this.objectTypes) {
         for(int var4 = 0; var4 < this.objectTypes.length; ++var4) {
            if(this.objectTypes[var4] == var1) {
               return class205.field3087.method3184(this.objectModels[var4] & '\uffff', 0);
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
            var2 &= class205.field3087.method3184(this.objectModels[var3] & '\uffff', 0);
         }

         return var2;
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(II[[IIIIB)LRenderable;",
      garbageValue = "0"
   )
   public final Renderable method3486(int var1, int var2, int[][] var3, int var4, int var5, int var6) {
      long var7;
      if(null == this.objectTypes) {
         var7 = (long)(var2 + (this.field2942 << 10));
      } else {
         var7 = (long)(var2 + (this.field2942 << 10) + (var1 << 3));
      }

      Object var9 = (Renderable)field2903.get(var7);
      if(var9 == null) {
         ModelData var10 = this.method3490(var1, var2);
         if(var10 == null) {
            return null;
         }

         if(!this.nonFlatShading) {
            var9 = var10.method1446(this.ambient + 64, this.contrast + 768, -50, -10, -50);
         } else {
            var10.field1268 = (short)(this.ambient + 64);
            var10.field1257 = (short)(this.contrast + 768);
            var10.computeNormals();
            var9 = var10;
         }

         field2903.put((CacheableNode)var9, var7);
      }

      if(this.nonFlatShading) {
         var9 = ((ModelData)var9).method1431();
      }

      if(this.field2919 >= 0) {
         if(var9 instanceof Model) {
            var9 = ((Model)var9).method1558(var3, var4, var5, var6, true, this.field2919);
         } else if(var9 instanceof ModelData) {
            var9 = ((ModelData)var9).method1499(var3, var4, var5, var6, true, this.field2919);
         }
      }

      return (Renderable)var9;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II[[IIIII)LModel;",
      garbageValue = "639687844"
   )
   public final Model method3488(int var1, int var2, int[][] var3, int var4, int var5, int var6) {
      long var7;
      if(this.objectTypes == null) {
         var7 = (long)(var2 + (this.field2942 << 10));
      } else {
         var7 = (long)(var2 + (var1 << 3) + (this.field2942 << 10));
      }

      Model var9 = (Model)field2940.get(var7);
      if(null == var9) {
         ModelData var10 = this.method3490(var1, var2);
         if(null == var10) {
            return null;
         }

         var9 = var10.method1446(this.ambient + 64, 768 + this.contrast, -50, -10, -50);
         field2940.put(var9, var7);
      }

      if(this.field2919 >= 0) {
         var9 = var9.method1558(var3, var4, var5, var6, true, this.field2919);
      }

      return var9;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(II[[IIIILSequence;IB)LModel;",
      garbageValue = "39"
   )
   public final Model method3489(int var1, int var2, int[][] var3, int var4, int var5, int var6, Sequence var7, int var8) {
      long var9;
      if(this.objectTypes == null) {
         var9 = (long)(var2 + (this.field2942 << 10));
      } else {
         var9 = (long)(var2 + (var1 << 3) + (this.field2942 << 10));
      }

      Model var11 = (Model)field2940.get(var9);
      if(null == var11) {
         ModelData var12 = this.method3490(var1, var2);
         if(null == var12) {
            return null;
         }

         var11 = var12.method1446(this.ambient + 64, 768 + this.contrast, -50, -10, -50);
         field2940.put(var11, var9);
      }

      if(var7 == null && this.field2919 == -1) {
         return var11;
      } else {
         if(var7 != null) {
            var11 = var7.method3632(var11, var8, var2);
         } else {
            var11 = var11.method1519(true);
         }

         if(this.field2919 >= 0) {
            var11 = var11.method1558(var3, var4, var5, var6, false, this.field2919);
         }

         return var11;
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(III)LModelData;",
      garbageValue = "608295467"
   )
   final ModelData method3490(int var1, int var2) {
      ModelData var3 = null;
      boolean var4;
      int var5;
      int var7;
      if(null == this.objectTypes) {
         if(var1 != 10) {
            return null;
         }

         if(this.objectModels == null) {
            return null;
         }

         var4 = this.field2929;
         if(var1 == 2 && var2 > 3) {
            var4 = !var4;
         }

         var5 = this.objectModels.length;

         for(int var6 = 0; var6 < var5; ++var6) {
            var7 = this.objectModels[var6];
            if(var4) {
               var7 += 65536;
            }

            var3 = (ModelData)field2902.get((long)var7);
            if(var3 == null) {
               var3 = ModelData.method1426(class205.field3087, var7 & '\uffff', 0);
               if(var3 == null) {
                  return null;
               }

               if(var4) {
                  var3.method1441();
               }

               field2902.put(var3, (long)var7);
            }

            if(var5 > 1) {
               field2905[var6] = var3;
            }
         }

         if(var5 > 1) {
            var3 = new ModelData(field2905, var5);
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
         boolean var10 = this.field2929 ^ var2 > 3;
         if(var10) {
            var5 += 65536;
         }

         var3 = (ModelData)field2902.get((long)var5);
         if(null == var3) {
            var3 = ModelData.method1426(class205.field3087, var5 & '\uffff', 0);
            if(var3 == null) {
               return null;
            }

            if(var10) {
               var3.method1441();
            }

            field2902.put(var3, (long)var5);
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
         var8.method1437(256);
         var8.method1467(45, 0, -45);
      }

      var2 &= 3;
      if(var2 == 1) {
         var8.method1434();
      } else if(var2 == 2) {
         var8.method1429();
      } else if(var2 == 3) {
         var8.method1486();
      }

      if(null != this.recolorToFind) {
         for(var7 = 0; var7 < this.recolorToFind.length; ++var7) {
            var8.method1439(this.recolorToFind[var7], this.recolorToReplace[var7]);
         }
      }

      if(this.textureToFind != null) {
         for(var7 = 0; var7 < this.textureToFind.length; ++var7) {
            var8.method1440(this.textureToFind[var7], this.textureToReplace[var7]);
         }
      }

      if(var4) {
         var8.method1449(this.modelSizeX, this.modelSizeHeight, this.modelSizeY);
      }

      if(var11) {
         var8.method1467(this.offsetX, this.offsetHeight, this.offsetY);
      }

      return var8;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)LObjectComposition;",
      garbageValue = "-1449514536"
   )
   @Export("getImpostor")
   public final ObjectComposition getImpostor() {
      int var1 = -1;
      if(this.varpId != -1) {
         var1 = class20.method174(this.varpId);
      } else if(this.configId != -1) {
         var1 = class165.widgetSettings[this.configId];
      }

      int var2;
      if(var1 >= 0 && var1 < this.impostorIds.length - 1) {
         var2 = this.impostorIds[var1];
      } else {
         var2 = this.impostorIds[this.impostorIds.length - 1];
      }

      return var2 != -1?class143.getObjectDefinition(var2):null;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1268837607"
   )
   public boolean method3492() {
      if(this.impostorIds == null) {
         return this.ambientSoundId != -1 || this.field2937 != null;
      } else {
         for(int var1 = 0; var1 < this.impostorIds.length; ++var1) {
            if(this.impostorIds[var1] != -1) {
               ObjectComposition var2 = class143.getObjectDefinition(this.impostorIds[var1]);
               if(var2.ambientSoundId != -1 || null != var2.field2937) {
                  return true;
               }
            }
         }

         return false;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "562832164"
   )
   public final boolean method3499() {
      if(this.objectModels == null) {
         return true;
      } else {
         boolean var1 = true;

         for(int var2 = 0; var2 < this.objectModels.length; ++var2) {
            var1 &= class205.field3087.method3184(this.objectModels[var2] & '\uffff', 0);
         }

         return var1;
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-467484024"
   )
   void method3512() {
      if(this.field2910 == -1) {
         this.field2910 = 0;
         if(this.objectModels != null && (null == this.objectTypes || this.objectTypes[0] == 10)) {
            this.field2910 = 1;
         }

         for(int var1 = 0; var1 < 5; ++var1) {
            if(this.actions[var1] != null) {
               this.field2910 = 1;
            }
         }
      }

      if(this.field2939 == -1) {
         this.field2939 = this.field2916 != 0?1:0;
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lclass159;S)V",
      garbageValue = "29511"
   )
   static final void method3516(class159 var0) {
      for(int var1 = 0; var1 < class45.field901; ++var1) {
         int var2 = class45.field904[var1];
         Player var3 = Client.cachedPlayers[var2];
         int var4 = var0.readUnsignedByte();
         if((var4 & 64) != 0) {
            var4 += var0.readUnsignedByte() << 8;
         }

         MessageNode.method180(var0, var2, var3, var4);
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIZI)Ljava/lang/String;",
      garbageValue = "1863473224"
   )
   public static String method3523(int var0, int var1, boolean var2) {
      if(var1 >= 2 && var1 <= 36) {
         if(var0 < 0) {
            return Integer.toString(var0, var1);
         } else {
            int var3 = 2;

            for(int var4 = var0 / var1; var4 != 0; ++var3) {
               var4 /= var1;
            }

            char[] var5 = new char[var3];
            var5[0] = 43;

            for(int var6 = var3 - 1; var6 > 0; --var6) {
               int var7 = var0;
               var0 /= var1;
               int var8 = var7 - var1 * var0;
               if(var8 >= 10) {
                  var5[var6] = (char)(var8 + 87);
               } else {
                  var5[var6] = (char)(var8 + 48);
               }
            }

            return new String(var5);
         }
      } else {
         throw new IllegalArgumentException("");
      }
   }
}
