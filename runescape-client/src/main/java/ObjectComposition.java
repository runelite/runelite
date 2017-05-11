import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gy")
@Implements("ObjectComposition")
public class ObjectComposition extends CacheableNode {
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = -139621155
   )
   public int field2923;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = -1888621547
   )
   @Export("modelSizeHeight")
   int modelSizeHeight;
   @ObfuscatedName("n")
   static IndexDataBase field2925;
   @ObfuscatedName("q")
   static NodeCache field2926;
   @ObfuscatedName("t")
   public static NodeCache field2927;
   @ObfuscatedName("p")
   static NodeCache field2928;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1802258465
   )
   @Export("animationId")
   public int animationId;
   @ObfuscatedName("z")
   static ModelData[] field2930;
   @ObfuscatedName("s")
   @Export("recolorToReplace")
   short[] recolorToReplace;
   @ObfuscatedName("v")
   @Export("objectModels")
   int[] objectModels;
   @ObfuscatedName("g")
   @Export("objectTypes")
   int[] objectTypes;
   @ObfuscatedName("w")
   @Export("name")
   public String name;
   @ObfuscatedName("r")
   @Export("recolorToFind")
   short[] recolorToFind;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -581467505
   )
   public int field2936;
   @ObfuscatedName("k")
   @Export("textureToFind")
   short[] textureToFind;
   @ObfuscatedName("e")
   @Export("textureToReplace")
   short[] textureToReplace;
   @ObfuscatedName("o")
   public boolean field2939;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -709520491
   )
   @Export("sizeY")
   public int sizeY;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -792867907
   )
   public int field2941;
   @ObfuscatedName("x")
   public boolean field2942;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -349730473
   )
   public int field2943;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1910892287
   )
   int field2944;
   @ObfuscatedName("f")
   @Export("nonFlatShading")
   boolean nonFlatShading;
   @ObfuscatedName("ap")
   class142 field2946;
   @ObfuscatedName("d")
   static boolean field2947;
   @ObfuscatedName("u")
   static NodeCache field2948;
   @ObfuscatedName("ak")
   @Export("isRotated")
   boolean isRotated;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = 1335897451
   )
   @Export("contrast")
   int contrast;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1192523269
   )
   public int field2951;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = 1482670155
   )
   @Export("mapIconId")
   public int mapIconId;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -779502249
   )
   @Export("mapSceneId")
   public int mapSceneId;
   @ObfuscatedName("af")
   @Export("isSolid")
   boolean isSolid;
   @ObfuscatedName("aa")
   public boolean field2955;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = 2024080329
   )
   @Export("modelSizeX")
   int modelSizeX;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = 867993677
   )
   @Export("offsetX")
   int offsetX;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 273842089
   )
   @Export("modelSizeY")
   int modelSizeY;
   @ObfuscatedName("ah")
   public int[] field2959;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = 1185666657
   )
   @Export("ambient")
   int ambient;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = 728774063
   )
   @Export("offsetY")
   int offsetY;
   @ObfuscatedName("ag")
   public boolean field2962;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1539337409
   )
   @Export("sizeX")
   public int sizeX;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = -1498955559
   )
   public int field2964;
   @ObfuscatedName("ab")
   @Export("impostorIds")
   public int[] impostorIds;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = 2114700095
   )
   @Export("varpId")
   int varpId;
   @ObfuscatedName("c")
   static IndexDataBase field2967;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = 754381823
   )
   @Export("ambientSoundId")
   public int ambientSoundId;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = -434749511
   )
   public int field2969;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = -355146077
   )
   @Export("configId")
   int configId;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = -325210007
   )
   public int field2971;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = -717421611
   )
   @Export("offsetHeight")
   int offsetHeight;
   @ObfuscatedName("ac")
   @Export("actions")
   public String[] actions;

   ObjectComposition() {
      this.name = "null";
      this.sizeX = 1;
      this.sizeY = 1;
      this.field2936 = 2;
      this.field2942 = true;
      this.field2943 = -1;
      this.field2944 = -1;
      this.nonFlatShading = false;
      this.field2939 = false;
      this.animationId = -1;
      this.field2951 = 16;
      this.ambient = 0;
      this.contrast = 0;
      this.actions = new String[5];
      this.mapIconId = -1;
      this.mapSceneId = -1;
      this.isRotated = false;
      this.field2955 = true;
      this.modelSizeX = 128;
      this.modelSizeHeight = 128;
      this.modelSizeY = 128;
      this.offsetX = 0;
      this.offsetHeight = 0;
      this.offsetY = 0;
      this.field2962 = false;
      this.isSolid = false;
      this.field2964 = -1;
      this.varpId = -1;
      this.configId = -1;
      this.ambientSoundId = -1;
      this.field2969 = 0;
      this.field2923 = 0;
      this.field2971 = 0;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-971537578"
   )
   @Export("loadData")
   void loadData(Buffer var1, int var2) {
      int var3;
      int var4;
      if(var2 == 1) {
         var3 = var1.readUnsignedByte();
         if(var3 > 0) {
            if(this.objectModels != null && !field2947) {
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
            if(this.objectModels != null && !field2947) {
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
         this.field2936 = 0;
         this.field2942 = false;
      } else if(var2 == 18) {
         this.field2942 = false;
      } else if(var2 == 19) {
         this.field2943 = var1.readUnsignedByte();
      } else if(var2 == 21) {
         this.field2944 = 0;
      } else if(var2 == 22) {
         this.nonFlatShading = true;
      } else if(var2 == 23) {
         this.field2939 = true;
      } else if(var2 == 24) {
         this.animationId = var1.readUnsignedShort();
         if(this.animationId == '\uffff') {
            this.animationId = -1;
         }
      } else if(var2 == 27) {
         this.field2936 = 1;
      } else if(var2 == 28) {
         this.field2951 = var1.readUnsignedByte();
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
      } else if(var2 == 60) {
         this.mapIconId = var1.readUnsignedShort();
      } else if(var2 == 62) {
         this.isRotated = true;
      } else if(var2 == 64) {
         this.field2955 = false;
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
         this.field2962 = true;
      } else if(var2 == 74) {
         this.isSolid = true;
      } else if(var2 == 75) {
         this.field2964 = var1.readUnsignedByte();
      } else if(var2 != 77 && var2 != 92) {
         if(var2 == 78) {
            this.ambientSoundId = var1.readUnsignedShort();
            this.field2969 = var1.readUnsignedByte();
         } else if(var2 == 79) {
            this.field2923 = var1.readUnsignedShort();
            this.field2971 = var1.readUnsignedShort();
            this.field2969 = var1.readUnsignedByte();
            var3 = var1.readUnsignedByte();
            this.field2959 = new int[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field2959[var4] = var1.readUnsignedShort();
            }
         } else if(var2 == 81) {
            this.field2944 = var1.readUnsignedByte() * 256;
         } else if(var2 == 249) {
            this.field2946 = class180.method3283(var1, this.field2946);
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
      signature = "(I)Z",
      garbageValue = "343169963"
   )
   public final boolean method3683() {
      if(this.objectModels == null) {
         return true;
      } else {
         boolean var1 = true;

         for(int var2 = 0; var2 < this.objectModels.length; ++var2) {
            var1 &= field2925.method3297(this.objectModels[var2] & '\uffff', 0);
         }

         return var1;
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II[[IIIIB)LRenderable;",
      garbageValue = "9"
   )
   public final Renderable method3684(int type, int orientation, int[][] var3, int var4, int var5, int var6) {
      long var7;
      if(this.objectTypes == null) {
         var7 = (long)((this.field2941 << 10) + orientation);
      } else {
         var7 = (long)(orientation + (type << 3) + (this.field2941 << 10));
      }

      Object var9 = (Renderable)field2928.get(var7);
      if(var9 == null) {
         ModelData var10 = this.method3697(type, orientation);
         if(var10 == null) {
            return null;
         }

         if(!this.nonFlatShading) {
            var9 = var10.method1502(this.ambient + 64, this.contrast + 768, -50, -10, -50);
         } else {
            var10.field1240 = (short)(this.ambient + 64);
            var10.field1218 = (short)(this.contrast + 768);
            var10.computeNormals();
            var9 = var10;
         }

         field2928.put((CacheableNode)var9, var7);
      }

      if(this.nonFlatShading) {
         var9 = ((ModelData)var9).method1507();
      }

      if(this.field2944 >= 0) {
         if(var9 instanceof Model) {
            var9 = ((Model)var9).method1613(var3, var4, var5, var6, true, this.field2944);
         } else if(var9 instanceof ModelData) {
            var9 = ((ModelData)var9).method1484(var3, var4, var5, var6, true, this.field2944);
         }
      }

      return (Renderable)var9;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(II[[IIIII)LModel;",
      garbageValue = "-544446928"
   )
   public final Model method3685(int var1, int var2, int[][] var3, int var4, int var5, int var6) {
      long var7;
      if(this.objectTypes == null) {
         var7 = (long)(var2 + (this.field2941 << 10));
      } else {
         var7 = (long)((var1 << 3) + (this.field2941 << 10) + var2);
      }

      Model var9 = (Model)field2948.get(var7);
      if(var9 == null) {
         ModelData var10 = this.method3697(var1, var2);
         if(var10 == null) {
            return null;
         }

         var9 = var10.method1502(this.ambient + 64, this.contrast + 768, -50, -10, -50);
         field2948.put(var9, var7);
      }

      if(this.field2944 >= 0) {
         var9 = var9.method1613(var3, var4, var5, var6, true, this.field2944);
      }

      return var9;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II[[IIIILSequence;II)LModel;",
      garbageValue = "-798223407"
   )
   public final Model method3686(int var1, int var2, int[][] var3, int var4, int var5, int var6, Sequence var7, int var8) {
      long var9;
      if(this.objectTypes == null) {
         var9 = (long)((this.field2941 << 10) + var2);
      } else {
         var9 = (long)((this.field2941 << 10) + (var1 << 3) + var2);
      }

      Model var11 = (Model)field2948.get(var9);
      if(var11 == null) {
         ModelData var12 = this.method3697(var1, var2);
         if(var12 == null) {
            return null;
         }

         var11 = var12.method1502(this.ambient + 64, this.contrast + 768, -50, -10, -50);
         field2948.put(var11, var9);
      }

      if(var7 == null && this.field2944 == -1) {
         return var11;
      } else {
         if(var7 != null) {
            var11 = var7.method3879(var11, var8, var2);
         } else {
            var11 = var11.method1571(true);
         }

         if(this.field2944 >= 0) {
            var11 = var11.method1613(var3, var4, var5, var6, false, this.field2944);
         }

         return var11;
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)LObjectComposition;",
      garbageValue = "2132372995"
   )
   @Export("getImpostor")
   public final ObjectComposition getImpostor() {
      int var1 = -1;
      if(this.varpId != -1) {
         var1 = class59.method1140(this.varpId);
      } else if(this.configId != -1) {
         var1 = class167.widgetSettings[this.configId];
      }

      int var2;
      if(var1 >= 0 && var1 < this.impostorIds.length - 1) {
         var2 = this.impostorIds[var1];
      } else {
         var2 = this.impostorIds[this.impostorIds.length - 1];
      }

      return var2 != -1?class26.getObjectDefinition(var2):null;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "1"
   )
   public boolean method3691() {
      if(this.impostorIds == null) {
         return this.ambientSoundId != -1 || this.field2959 != null;
      } else {
         for(int var1 = 0; var1 < this.impostorIds.length; ++var1) {
            if(this.impostorIds[var1] != -1) {
               ObjectComposition var2 = class26.getObjectDefinition(this.impostorIds[var1]);
               if(var2.ambientSoundId != -1 || var2.field2959 != null) {
                  return true;
               }
            }
         }

         return false;
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-112"
   )
   void method3692() {
      if(this.field2943 == -1) {
         this.field2943 = 0;
         if(this.objectModels != null && (this.objectTypes == null || this.objectTypes[0] == 10)) {
            this.field2943 = 1;
         }

         for(int var1 = 0; var1 < 5; ++var1) {
            if(this.actions[var1] != null) {
               this.field2943 = 1;
            }
         }
      }

      if(this.field2964 == -1) {
         this.field2964 = this.field2936 != 0?1:0;
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-165958041"
   )
   void method3693(Buffer var1) {
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
      signature = "(III)I",
      garbageValue = "-1950712638"
   )
   public int method3694(int var1, int var2) {
      return IndexData.method3408(this.field2946, var1, var2);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(III)LModelData;",
      garbageValue = "2109167621"
   )
   final ModelData method3697(int type, int orientation) {
      ModelData var3 = null;
      boolean var4;
      int var5;
      int var7;
      if(this.objectTypes == null) {
         if(type != 10) {
            return null;
         }

         if(this.objectModels == null) {
            return null;
         }

         var4 = this.isRotated;
         if(type == 2 && orientation > 3) {
            var4 = !var4;
         }

         var5 = this.objectModels.length;

         for(int var6 = 0; var6 < var5; ++var6) {
            var7 = this.objectModels[var6];
            if(var4) {
               var7 += 65536;
            }

            var3 = (ModelData)field2927.get((long)var7);
            if(var3 == null) {
               var3 = ModelData.method1479(field2925, var7 & '\uffff', 0);
               if(var3 == null) {
                  return null;
               }

               if(var4) {
                  var3.method1493();
               }

               field2927.put(var3, (long)var7);
            }

            if(var5 > 1) {
               field2930[var6] = var3;
            }
         }

         if(var5 > 1) {
            var3 = new ModelData(field2930, var5);
         }
      } else {
         int var9 = -1;

         for(var5 = 0; var5 < this.objectTypes.length; ++var5) {
            if(this.objectTypes[var5] == type) {
               var9 = var5;
               break;
            }
         }

         if(var9 == -1) {
            return null;
         }

         var5 = this.objectModels[var9];
         boolean var10 = this.isRotated ^ orientation > 3;
         if(var10) {
            var5 += 65536;
         }

         var3 = (ModelData)field2927.get((long)var5);
         if(var3 == null) {
            var3 = ModelData.method1479(field2925, var5 & '\uffff', 0);
            if(var3 == null) {
               return null;
            }

            if(var10) {
               var3.method1493();
            }

            field2927.put(var3, (long)var5);
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

      ModelData var8 = new ModelData(var3, orientation == 0 && !var4 && !var11, this.recolorToFind == null, this.textureToFind == null, true);
      if(type == 4 && orientation > 3) {
         var8.method1489(256);
         var8.method1535(45, 0, -45);
      }

      orientation &= 3;
      if(orientation == 1) {
         var8.method1542();
      } else if(orientation == 2) {
         var8.method1487();
      } else if(orientation == 3) {
         var8.method1488();
      }

      if(this.recolorToFind != null) {
         for(var7 = 0; var7 < this.recolorToFind.length; ++var7) {
            var8.method1491(this.recolorToFind[var7], this.recolorToReplace[var7]);
         }
      }

      if(this.textureToFind != null) {
         for(var7 = 0; var7 < this.textureToFind.length; ++var7) {
            var8.method1492(this.textureToFind[var7], this.textureToReplace[var7]);
         }
      }

      if(var4) {
         var8.method1494(this.modelSizeX, this.modelSizeHeight, this.modelSizeY);
      }

      if(var11) {
         var8.method1535(this.offsetX, this.offsetHeight, this.offsetY);
      }

      return var8;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)Ljava/lang/String;",
      garbageValue = "-28984294"
   )
   public String method3720(int var1, String var2) {
      return class164.method3100(this.field2946, var1, var2);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-1801221141"
   )
   public final boolean method3725(int var1) {
      if(this.objectTypes != null) {
         for(int var4 = 0; var4 < this.objectTypes.length; ++var4) {
            if(var1 == this.objectTypes[var4]) {
               return field2925.method3297(this.objectModels[var4] & '\uffff', 0);
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
            var2 &= field2925.method3297(this.objectModels[var3] & '\uffff', 0);
         }

         return var2;
      }
   }

   static {
      field2947 = false;
      field2926 = new NodeCache(64);
      field2927 = new NodeCache(500);
      field2928 = new NodeCache(30);
      field2948 = new NodeCache(30);
      field2930 = new ModelData[4];
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;I)V",
      garbageValue = "467777460"
   )
   public static void method3733(IndexDataBase var0) {
      Overlay.field3081 = var0;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;Ljava/lang/String;Ljava/lang/String;B)[LSpritePixels;",
      garbageValue = "-81"
   )
   public static SpritePixels[] method3734(IndexDataBase var0, String var1, String var2) {
      int var3 = var0.method3296(var1);
      int var4 = var0.method3310(var3, var2);
      SpritePixels[] var5;
      if(!class199.method3620(var0, var3, var4)) {
         var5 = null;
      } else {
         SpritePixels[] var7 = new SpritePixels[class229.field3250];

         for(int var8 = 0; var8 < class229.field3250; ++var8) {
            SpritePixels var9 = var7[var8] = new SpritePixels();
            var9.maxWidth = class229.field3255;
            var9.maxHeight = class229.field3251;
            var9.offsetX = class199.field2877[var8];
            var9.offsetY = class229.field3252[var8];
            var9.width = class229.field3254[var8];
            var9.height = class36.field772[var8];
            int var10 = var9.width * var9.height;
            byte[] var11 = class229.field3253[var8];
            var9.image = new int[var10];

            for(int var12 = 0; var12 < var10; ++var12) {
               var9.image[var12] = class229.field3249[var11[var12] & 255];
            }
         }

         class199.field2877 = null;
         class229.field3252 = null;
         class229.field3254 = null;
         class36.field772 = null;
         class229.field3249 = null;
         class229.field3253 = null;
         var5 = var7;
      }

      return var5;
   }
}
