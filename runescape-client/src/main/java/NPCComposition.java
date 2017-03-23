import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gv")
@Implements("NPCComposition")
public class NPCComposition extends CacheableNode {
   @ObfuscatedName("m")
   int[] field3005;
   @ObfuscatedName("v")
   short[] field3006;
   @ObfuscatedName("ak")
   public boolean field3007 = false;
   @ObfuscatedName("h")
   @Export("npcModelCache")
   public static NodeCache npcModelCache = new NodeCache(50);
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1699993407
   )
   @Export("id")
   public int id;
   @ObfuscatedName("o")
   @Export("name")
   public String name = "null";
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 111851533
   )
   public int field3011 = 1;
   @ObfuscatedName("n")
   @Export("models")
   int[] models;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = -2077897377
   )
   int field3013 = 0;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1276643429
   )
   public int field3014 = -1;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 276563
   )
   public int field3016 = -1;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 543019365
   )
   public int field3017 = -1;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1679586493
   )
   public int field3018 = -1;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -886302387
   )
   public int field3019 = -1;
   @ObfuscatedName("ax")
   public boolean field3020 = true;
   @ObfuscatedName("a")
   short[] field3021;
   @ObfuscatedName("f")
   public static class182 field3022;
   @ObfuscatedName("z")
   short[] field3023;
   @ObfuscatedName("x")
   short[] field3024;
   @ObfuscatedName("g")
   @Export("actions")
   public String[] actions = new String[5];
   @ObfuscatedName("u")
   public static NodeCache field3026 = new NodeCache(64);
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -8084963
   )
   @Export("combatLevel")
   public int combatLevel = -1;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 2078597635
   )
   int field3028 = 128;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -773375789
   )
   int field3029 = 128;
   @ObfuscatedName("e")
   @Export("isVisible")
   public boolean isVisible = false;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 891886091
   )
   public int field3031 = -1;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = -709528167
   )
   int field3032 = 0;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = 1901823527
   )
   public int field3033 = -1;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = -125708389
   )
   public int field3034 = 32;
   @ObfuscatedName("ag")
   @Export("configs")
   public int[] configs;
   @ObfuscatedName("i")
   public static class182 field3036;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = 2104058915
   )
   int field3037 = -1;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1457072669
   )
   public int field3038 = -1;
   @ObfuscatedName("ar")
   @Export("isClickable")
   public boolean isClickable = true;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = -1537897513
   )
   int field3040 = -1;
   @ObfuscatedName("b")
   @Export("isMinimapVisible")
   public boolean isMinimapVisible = true;

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-750045694"
   )
   void method3737(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3748(var1, var2);
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(LSequence;ILSequence;IB)LModel;",
      garbageValue = "1"
   )
   public final Model method3739(Sequence var1, int var2, Sequence var3, int var4) {
      if(this.configs != null) {
         NPCComposition var12 = this.method3741();
         return null == var12?null:var12.method3739(var1, var2, var3, var4);
      } else {
         Model var5 = (Model)npcModelCache.get((long)this.id);
         if(null == var5) {
            boolean var6 = false;

            for(int var7 = 0; var7 < this.models.length; ++var7) {
               if(!field3036.method3338(this.models[var7], 0)) {
                  var6 = true;
               }
            }

            if(var6) {
               return null;
            }

            ModelData[] var8 = new ModelData[this.models.length];

            int var9;
            for(var9 = 0; var9 < this.models.length; ++var9) {
               var8[var9] = ModelData.method1495(field3036, this.models[var9], 0);
            }

            ModelData var11;
            if(var8.length == 1) {
               var11 = var8[0];
            } else {
               var11 = new ModelData(var8, var8.length);
            }

            if(this.field3021 != null) {
               for(var9 = 0; var9 < this.field3021.length; ++var9) {
                  var11.method1509(this.field3021[var9], this.field3006[var9]);
               }
            }

            if(null != this.field3023) {
               for(var9 = 0; var9 < this.field3023.length; ++var9) {
                  var11.method1510(this.field3023[var9], this.field3024[var9]);
               }
            }

            var5 = var11.method1524(this.field3013 + 64, 850 + this.field3032, -30, -50, -30);
            npcModelCache.put(var5, (long)this.id);
         }

         Model var10;
         if(var1 != null && null != var3) {
            var10 = var1.method3792(var5, var2, var3, var4);
         } else if(null != var1) {
            var10 = var1.method3789(var5, var2);
         } else if(null != var3) {
            var10 = var3.method3789(var5, var4);
         } else {
            var10 = var5.method1584(true);
         }

         if(this.field3028 != 128 || this.field3029 != 128) {
            var10.method1614(this.field3028, this.field3029, this.field3028);
         }

         return var10;
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(B)LModelData;",
      garbageValue = "-103"
   )
   public final ModelData method3740() {
      if(this.configs != null) {
         NPCComposition var1 = this.method3741();
         return null == var1?null:var1.method3740();
      } else if(null == this.field3005) {
         return null;
      } else {
         boolean var5 = false;

         for(int var2 = 0; var2 < this.field3005.length; ++var2) {
            if(!field3036.method3338(this.field3005[var2], 0)) {
               var5 = true;
            }
         }

         if(var5) {
            return null;
         } else {
            ModelData[] var7 = new ModelData[this.field3005.length];

            for(int var6 = 0; var6 < this.field3005.length; ++var6) {
               var7[var6] = ModelData.method1495(field3036, this.field3005[var6], 0);
            }

            ModelData var3;
            if(var7.length == 1) {
               var3 = var7[0];
            } else {
               var3 = new ModelData(var7, var7.length);
            }

            int var4;
            if(null != this.field3021) {
               for(var4 = 0; var4 < this.field3021.length; ++var4) {
                  var3.method1509(this.field3021[var4], this.field3006[var4]);
               }
            }

            if(null != this.field3023) {
               for(var4 = 0; var4 < this.field3023.length; ++var4) {
                  var3.method1510(this.field3023[var4], this.field3024[var4]);
               }
            }

            return var3;
         }
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(B)LNPCComposition;",
      garbageValue = "-25"
   )
   public final NPCComposition method3741() {
      int var1 = -1;
      if(this.field3040 != -1) {
         var1 = class25.method560(this.field3040);
      } else if(this.field3037 != -1) {
         var1 = class165.widgetSettings[this.field3037];
      }

      int var2;
      if(var1 >= 0 && var1 < this.configs.length - 1) {
         var2 = this.configs[var1];
      } else {
         var2 = this.configs[this.configs.length - 1];
      }

      return var2 != -1?class15.getNpcDefinition(var2):null;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1435314390"
   )
   public boolean method3742() {
      if(null == this.configs) {
         return true;
      } else {
         int var1 = -1;
         if(this.field3040 != -1) {
            var1 = class25.method560(this.field3040);
         } else if(this.field3037 != -1) {
            var1 = class165.widgetSettings[this.field3037];
         }

         return var1 >= 0 && var1 < this.configs.length?this.configs[var1] != -1:this.configs[this.configs.length - 1] != -1;
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "268660844"
   )
   void method3748(Buffer var1, int var2) {
      int var3;
      int var4;
      if(var2 == 1) {
         var3 = var1.readUnsignedByte();
         this.models = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.models[var4] = var1.readUnsignedShort();
         }
      } else if(var2 == 2) {
         this.name = var1.readString();
      } else if(var2 == 12) {
         this.field3011 = var1.readUnsignedByte();
      } else if(var2 == 13) {
         this.field3014 = var1.readUnsignedShort();
      } else if(var2 == 14) {
         this.field3017 = var1.readUnsignedShort();
      } else if(var2 == 15) {
         this.field3038 = var1.readUnsignedShort();
      } else if(var2 == 16) {
         this.field3016 = var1.readUnsignedShort();
      } else if(var2 == 17) {
         this.field3017 = var1.readUnsignedShort();
         this.field3018 = var1.readUnsignedShort();
         this.field3019 = var1.readUnsignedShort();
         this.field3031 = var1.readUnsignedShort();
      } else if(var2 >= 30 && var2 < 35) {
         this.actions[var2 - 30] = var1.readString();
         if(this.actions[var2 - 30].equalsIgnoreCase("Hidden")) {
            this.actions[var2 - 30] = null;
         }
      } else if(var2 == 40) {
         var3 = var1.readUnsignedByte();
         this.field3021 = new short[var3];
         this.field3006 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3021[var4] = (short)var1.readUnsignedShort();
            this.field3006[var4] = (short)var1.readUnsignedShort();
         }
      } else if(var2 == 41) {
         var3 = var1.readUnsignedByte();
         this.field3023 = new short[var3];
         this.field3024 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3023[var4] = (short)var1.readUnsignedShort();
            this.field3024[var4] = (short)var1.readUnsignedShort();
         }
      } else if(var2 == 60) {
         var3 = var1.readUnsignedByte();
         this.field3005 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3005[var4] = var1.readUnsignedShort();
         }
      } else if(var2 == 93) {
         this.isMinimapVisible = false;
      } else if(var2 == 95) {
         this.combatLevel = var1.readUnsignedShort();
      } else if(var2 == 97) {
         this.field3028 = var1.readUnsignedShort();
      } else if(var2 == 98) {
         this.field3029 = var1.readUnsignedShort();
      } else if(var2 == 99) {
         this.isVisible = true;
      } else if(var2 == 100) {
         this.field3013 = var1.readByte();
      } else if(var2 == 101) {
         this.field3032 = var1.readByte() * 5;
      } else if(var2 == 102) {
         this.field3033 = var1.readUnsignedShort();
      } else if(var2 == 103) {
         this.field3034 = var1.readUnsignedShort();
      } else if(var2 != 106 && var2 != 118) {
         if(var2 == 107) {
            this.field3020 = false;
         } else if(var2 == 109) {
            this.isClickable = false;
         } else if(var2 == 111) {
            this.field3007 = true;
         }
      } else {
         this.field3040 = var1.readUnsignedShort();
         if(this.field3040 == '\uffff') {
            this.field3040 = -1;
         }

         this.field3037 = var1.readUnsignedShort();
         if(this.field3037 == '\uffff') {
            this.field3037 = -1;
         }

         var3 = -1;
         if(var2 == 118) {
            var3 = var1.readUnsignedShort();
            if(var3 == '\uffff') {
               var3 = -1;
            }
         }

         var4 = var1.readUnsignedByte();
         this.configs = new int[var4 + 2];

         for(int var5 = 0; var5 <= var4; ++var5) {
            this.configs[var5] = var1.readUnsignedShort();
            if(this.configs[var5] == '\uffff') {
               this.configs[var5] = -1;
            }
         }

         this.configs[var4 + 1] = var3;
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-444888677"
   )
   void method3752() {
   }
}
