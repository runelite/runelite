import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gl")
@Implements("NPCComposition")
public class NPCComposition extends CacheableNode {
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1775239021
   )
   int field2981 = 128;
   @ObfuscatedName("y")
   static class182 field2982;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = 2144873823
   )
   int field2983 = 0;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = 192836947
   )
   public int field2984 = 32;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = 686926641
   )
   public int field2985 = -1;
   @ObfuscatedName("o")
   static NodeCache field2986 = new NodeCache(64);
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -16551767
   )
   public int field2987 = 1;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = 614065597
   )
   int field2988 = 0;
   @ObfuscatedName("n")
   int[] field2989;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -48533951
   )
   public int field2990 = -1;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1131945365
   )
   public int field2991 = -1;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1197223981
   )
   public int field2992 = -1;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 116520931
   )
   public int field2993 = -1;
   @ObfuscatedName("j")
   @Export("name")
   public String name = "null";
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1015801319
   )
   public int field2995 = -1;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -906254435
   )
   public int field2996 = -1;
   @ObfuscatedName("p")
   short[] field2997;
   @ObfuscatedName("t")
   short[] field2998;
   @ObfuscatedName("r")
   @Export("npcModelCache")
   static NodeCache npcModelCache = new NodeCache(50);
   @ObfuscatedName("z")
   short[] field3000;
   @ObfuscatedName("u")
   @Export("actions")
   public String[] actions = new String[5];
   @ObfuscatedName("b")
   @Export("isMinimapVisible")
   public boolean isMinimapVisible = true;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 492855685
   )
   @Export("combatLevel")
   public int combatLevel = -1;
   @ObfuscatedName("d")
   @Export("models")
   int[] models;
   @ObfuscatedName("qb")
   @ObfuscatedGetter(
      intValue = 1217397545
   )
   static int field3005;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 418122779
   )
   int field3006 = 128;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -911066419
   )
   public int field3007 = -1;
   @ObfuscatedName("k")
   static class182 field3008;
   @ObfuscatedName("x")
   @Export("isVisible")
   public boolean isVisible = false;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -644397589
   )
   @Export("id")
   public int id;
   @ObfuscatedName("ah")
   @Export("configs")
   public int[] configs;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = 676759981
   )
   int field3012 = -1;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = 1973423
   )
   int field3013 = -1;
   @ObfuscatedName("af")
   public boolean field3014 = true;
   @ObfuscatedName("aj")
   @Export("isClickable")
   public boolean isClickable = true;
   @ObfuscatedName("am")
   public boolean field3016 = false;
   @ObfuscatedName("f")
   short[] field3017;

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1687588102"
   )
   void method3700() {
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "-8"
   )
   void method3701(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3719(var1, var2);
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-538095352"
   )
   public boolean method3702() {
      if(null == this.configs) {
         return true;
      } else {
         int var1 = -1;
         if(this.field3012 != -1) {
            var1 = class10.method127(this.field3012);
         } else if(this.field3013 != -1) {
            var1 = class146.widgetSettings[this.field3013];
         }

         return var1 >= 0 && var1 < this.configs.length?this.configs[var1] != -1:this.configs[this.configs.length - 1] != -1;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(LSequence;ILSequence;II)LModel;",
      garbageValue = "-538743171"
   )
   public final Model method3703(Sequence var1, int var2, Sequence var3, int var4) {
      if(this.configs != null) {
         NPCComposition var12 = this.method3729();
         return null == var12?null:var12.method3703(var1, var2, var3, var4);
      } else {
         Model var5 = (Model)npcModelCache.get((long)this.id);
         if(null == var5) {
            boolean var6 = false;

            for(int var10 = 0; var10 < this.models.length; ++var10) {
               if(!field2982.method3275(this.models[var10], 0)) {
                  var6 = true;
               }
            }

            if(var6) {
               return null;
            }

            ModelData[] var8 = new ModelData[this.models.length];

            int var9;
            for(var9 = 0; var9 < this.models.length; ++var9) {
               var8[var9] = ModelData.method1470(field2982, this.models[var9], 0);
            }

            ModelData var7;
            if(var8.length == 1) {
               var7 = var8[0];
            } else {
               var7 = new ModelData(var8, var8.length);
            }

            if(null != this.field2997) {
               for(var9 = 0; var9 < this.field2997.length; ++var9) {
                  var7.method1474(this.field2997[var9], this.field2998[var9]);
               }
            }

            if(null != this.field3017) {
               for(var9 = 0; var9 < this.field3017.length; ++var9) {
                  var7.method1484(this.field3017[var9], this.field3000[var9]);
               }
            }

            var5 = var7.method1491(this.field2983 + 64, 850 + this.field2988, -30, -50, -30);
            npcModelCache.put(var5, (long)this.id);
         }

         Model var11;
         if(var1 != null && var3 != null) {
            var11 = var1.method3760(var5, var2, var3, var4);
         } else if(null != var1) {
            var11 = var1.method3757(var5, var2);
         } else if(var3 != null) {
            var11 = var3.method3757(var5, var4);
         } else {
            var11 = var5.method1565(true);
         }

         if(this.field3006 != 128 || this.field2981 != 128) {
            var11.method1621(this.field3006, this.field2981, this.field3006);
         }

         return var11;
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)LModelData;",
      garbageValue = "-733287244"
   )
   public final ModelData method3704() {
      if(null != this.configs) {
         NPCComposition var1 = this.method3729();
         return null == var1?null:var1.method3704();
      } else if(null == this.field2989) {
         return null;
      } else {
         boolean var5 = false;

         for(int var2 = 0; var2 < this.field2989.length; ++var2) {
            if(!field2982.method3275(this.field2989[var2], 0)) {
               var5 = true;
            }
         }

         if(var5) {
            return null;
         } else {
            ModelData[] var6 = new ModelData[this.field2989.length];

            for(int var3 = 0; var3 < this.field2989.length; ++var3) {
               var6[var3] = ModelData.method1470(field2982, this.field2989[var3], 0);
            }

            ModelData var7;
            if(var6.length == 1) {
               var7 = var6[0];
            } else {
               var7 = new ModelData(var6, var6.length);
            }

            int var4;
            if(this.field2997 != null) {
               for(var4 = 0; var4 < this.field2997.length; ++var4) {
                  var7.method1474(this.field2997[var4], this.field2998[var4]);
               }
            }

            if(this.field3017 != null) {
               for(var4 = 0; var4 < this.field3017.length; ++var4) {
                  var7.method1484(this.field3017[var4], this.field3000[var4]);
               }
            }

            return var7;
         }
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(LBuffer;IB)V",
      garbageValue = "6"
   )
   void method3719(Buffer var1, int var2) {
      int var3;
      int var4;
      if(var2 == 1) {
         var3 = var1.readUnsignedByte();
         this.models = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.models[var4] = var1.readUnsignedShort();
         }
      } else if(var2 == 2) {
         this.name = var1.method2934();
      } else if(var2 == 12) {
         this.field2987 = var1.readUnsignedByte();
      } else if(var2 == 13) {
         this.field2990 = var1.readUnsignedShort();
      } else if(var2 == 14) {
         this.field2993 = var1.readUnsignedShort();
      } else if(var2 == 15) {
         this.field2991 = var1.readUnsignedShort();
      } else if(var2 == 16) {
         this.field2992 = var1.readUnsignedShort();
      } else if(var2 == 17) {
         this.field2993 = var1.readUnsignedShort();
         this.field3007 = var1.readUnsignedShort();
         this.field2995 = var1.readUnsignedShort();
         this.field2996 = var1.readUnsignedShort();
      } else if(var2 >= 30 && var2 < 35) {
         this.actions[var2 - 30] = var1.method2934();
         if(this.actions[var2 - 30].equalsIgnoreCase("Hidden")) {
            this.actions[var2 - 30] = null;
         }
      } else if(var2 == 40) {
         var3 = var1.readUnsignedByte();
         this.field2997 = new short[var3];
         this.field2998 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field2997[var4] = (short)var1.readUnsignedShort();
            this.field2998[var4] = (short)var1.readUnsignedShort();
         }
      } else if(var2 == 41) {
         var3 = var1.readUnsignedByte();
         this.field3017 = new short[var3];
         this.field3000 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3017[var4] = (short)var1.readUnsignedShort();
            this.field3000[var4] = (short)var1.readUnsignedShort();
         }
      } else if(var2 == 60) {
         var3 = var1.readUnsignedByte();
         this.field2989 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field2989[var4] = var1.readUnsignedShort();
         }
      } else if(var2 == 93) {
         this.isMinimapVisible = false;
      } else if(var2 == 95) {
         this.combatLevel = var1.readUnsignedShort();
      } else if(var2 == 97) {
         this.field3006 = var1.readUnsignedShort();
      } else if(var2 == 98) {
         this.field2981 = var1.readUnsignedShort();
      } else if(var2 == 99) {
         this.isVisible = true;
      } else if(var2 == 100) {
         this.field2983 = var1.readByte();
      } else if(var2 == 101) {
         this.field2988 = var1.readByte() * 5;
      } else if(var2 == 102) {
         this.field2985 = var1.readUnsignedShort();
      } else if(var2 == 103) {
         this.field2984 = var1.readUnsignedShort();
      } else if(var2 != 106 && var2 != 118) {
         if(var2 == 107) {
            this.field3014 = false;
         } else if(var2 == 109) {
            this.isClickable = false;
         } else if(var2 == 111) {
            this.field3016 = true;
         }
      } else {
         this.field3012 = var1.readUnsignedShort();
         if(this.field3012 == '\uffff') {
            this.field3012 = -1;
         }

         this.field3013 = var1.readUnsignedShort();
         if(this.field3013 == '\uffff') {
            this.field3013 = -1;
         }

         var3 = -1;
         if(var2 == 118) {
            var3 = var1.readUnsignedShort();
            if(var3 == '\uffff') {
               var3 = -1;
            }
         }

         var4 = var1.readUnsignedByte();
         this.configs = new int[2 + var4];

         for(int var5 = 0; var5 <= var4; ++var5) {
            this.configs[var5] = var1.readUnsignedShort();
            if(this.configs[var5] == '\uffff') {
               this.configs[var5] = -1;
            }
         }

         this.configs[1 + var4] = var3;
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)LNPCComposition;",
      garbageValue = "15"
   )
   public final NPCComposition method3729() {
      int var1 = -1;
      if(this.field3012 != -1) {
         var1 = class10.method127(this.field3012);
      } else if(this.field3013 != -1) {
         var1 = class146.widgetSettings[this.field3013];
      }

      int var2;
      if(var1 >= 0 && var1 < this.configs.length - 1) {
         var2 = this.configs[var1];
      } else {
         var2 = this.configs[this.configs.length - 1];
      }

      return var2 != -1?class45.getNpcDefinition(var2):null;
   }
}
