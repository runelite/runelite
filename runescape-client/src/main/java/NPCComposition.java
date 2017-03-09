import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gw")
@Implements("NPCComposition")
public class NPCComposition extends CacheableNode {
   @ObfuscatedName("x")
   static class182 field3002;
   @ObfuscatedName("j")
   static class182 field3003;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1390508621
   )
   int field3004 = 128;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -321194629
   )
   public int field3005 = -1;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -261911991
   )
   @Export("id")
   public int id;
   @ObfuscatedName("d")
   @Export("npcModelCache")
   static NodeCache npcModelCache = new NodeCache(50);
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1023946421
   )
   public int field3008 = 1;
   @ObfuscatedName("k")
   @Export("models")
   int[] models;
   @ObfuscatedName("g")
   int[] field3010;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1163569057
   )
   public int field3011 = -1;
   @ObfuscatedName("c")
   static NodeCache field3013 = new NodeCache(64);
   @ObfuscatedName("i")
   short[] field3014;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -2044706241
   )
   public int field3015 = -1;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -392291655
   )
   int field3016 = 128;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -76993755
   )
   public int field3017 = -1;
   @ObfuscatedName("m")
   short[] field3018;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -922147927
   )
   public int field3019 = -1;
   @ObfuscatedName("f")
   short[] field3020;
   @ObfuscatedName("b")
   short[] field3021;
   @ObfuscatedName("t")
   @Export("actions")
   public String[] actions = new String[5];
   @ObfuscatedName("z")
   @Export("isMinimapVisible")
   public boolean isMinimapVisible = true;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1764813579
   )
   @Export("combatLevel")
   public int combatLevel = -1;
   @ObfuscatedName("o")
   @Export("isVisible")
   public boolean isVisible = false;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = -438341715
   )
   int field3026 = -1;
   @ObfuscatedName("h")
   @Export("name")
   public String name = "null";
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = -1835831249
   )
   int field3028 = 0;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = -1164077029
   )
   int field3029 = 0;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = 579367989
   )
   public int field3030 = -1;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = 2072323133
   )
   public int field3031 = 32;
   @ObfuscatedName("ax")
   @Export("configs")
   public int[] configs;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1112589075
   )
   public int field3033 = -1;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = 91186749
   )
   int field3034 = -1;
   @ObfuscatedName("at")
   public boolean field3035 = true;
   @ObfuscatedName("ab")
   @Export("isClickable")
   public boolean isClickable = true;
   @ObfuscatedName("ae")
   public boolean field3037 = false;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1746996875
   )
   public int field3038 = -1;
   @ObfuscatedName("hy")
   @ObfuscatedGetter(
      intValue = 777263057
   )
   @Export("menuHeight")
   static int menuHeight;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "1953184924"
   )
   void method3706(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3737(var1, var2);
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(LSequence;ILSequence;IB)LModel;",
      garbageValue = "34"
   )
   public final Model method3708(Sequence var1, int var2, Sequence var3, int var4) {
      if(this.configs != null) {
         NPCComposition var12 = this.method3719();
         return var12 == null?null:var12.method3708(var1, var2, var3, var4);
      } else {
         Model var5 = (Model)npcModelCache.get((long)this.id);
         if(null == var5) {
            boolean var10 = false;

            for(int var7 = 0; var7 < this.models.length; ++var7) {
               if(!field3003.method3374(this.models[var7], 0)) {
                  var10 = true;
               }
            }

            if(var10) {
               return null;
            }

            ModelData[] var8 = new ModelData[this.models.length];

            int var9;
            for(var9 = 0; var9 < this.models.length; ++var9) {
               var8[var9] = ModelData.method1522(field3003, this.models[var9], 0);
            }

            ModelData var11;
            if(var8.length == 1) {
               var11 = var8[0];
            } else {
               var11 = new ModelData(var8, var8.length);
            }

            if(null != this.field3018) {
               for(var9 = 0; var9 < this.field3018.length; ++var9) {
                  var11.method1555(this.field3018[var9], this.field3014[var9]);
               }
            }

            if(null != this.field3020) {
               for(var9 = 0; var9 < this.field3020.length; ++var9) {
                  var11.method1536(this.field3020[var9], this.field3021[var9]);
               }
            }

            var5 = var11.method1543(this.field3028 + 64, this.field3029 + 850, -30, -50, -30);
            npcModelCache.put(var5, (long)this.id);
         }

         Model var6;
         if(null != var1 && var3 != null) {
            var6 = var1.method3777(var5, var2, var3, var4);
         } else if(var1 != null) {
            var6 = var1.method3763(var5, var2);
         } else if(null != var3) {
            var6 = var3.method3763(var5, var4);
         } else {
            var6 = var5.method1614(true);
         }

         if(this.field3004 != 128 || this.field3016 != 128) {
            var6.method1627(this.field3004, this.field3016, this.field3004);
         }

         return var6;
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)LModelData;",
      garbageValue = "1014367729"
   )
   public final ModelData method3709() {
      if(null != this.configs) {
         NPCComposition var1 = this.method3719();
         return var1 == null?null:var1.method3709();
      } else if(this.field3010 == null) {
         return null;
      } else {
         boolean var6 = false;

         for(int var5 = 0; var5 < this.field3010.length; ++var5) {
            if(!field3003.method3374(this.field3010[var5], 0)) {
               var6 = true;
            }
         }

         if(var6) {
            return null;
         } else {
            ModelData[] var2 = new ModelData[this.field3010.length];

            for(int var7 = 0; var7 < this.field3010.length; ++var7) {
               var2[var7] = ModelData.method1522(field3003, this.field3010[var7], 0);
            }

            ModelData var3;
            if(var2.length == 1) {
               var3 = var2[0];
            } else {
               var3 = new ModelData(var2, var2.length);
            }

            int var4;
            if(this.field3018 != null) {
               for(var4 = 0; var4 < this.field3018.length; ++var4) {
                  var3.method1555(this.field3018[var4], this.field3014[var4]);
               }
            }

            if(this.field3020 != null) {
               for(var4 = 0; var4 < this.field3020.length; ++var4) {
                  var3.method1536(this.field3020[var4], this.field3021[var4]);
               }
            }

            return var3;
         }
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1953770230"
   )
   public boolean method3711() {
      if(this.configs == null) {
         return true;
      } else {
         int var1 = -1;
         if(this.field3026 != -1) {
            var1 = class88.method1937(this.field3026);
         } else if(this.field3034 != -1) {
            var1 = class165.widgetSettings[this.field3034];
         }

         return var1 >= 0 && var1 < this.configs.length?this.configs[var1] != -1:this.configs[this.configs.length - 1] != -1;
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)LNPCComposition;",
      garbageValue = "-386978022"
   )
   public final NPCComposition method3719() {
      int var1 = -1;
      if(this.field3026 != -1) {
         var1 = class88.method1937(this.field3026);
      } else if(this.field3034 != -1) {
         var1 = class165.widgetSettings[this.field3034];
      }

      int var2;
      if(var1 >= 0 && var1 < this.configs.length - 1) {
         var2 = this.configs[var1];
      } else {
         var2 = this.configs[this.configs.length - 1];
      }

      return var2 != -1?VertexNormal.getNpcDefinition(var2):null;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "23197450"
   )
   void method3730() {
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(LBuffer;IB)V",
      garbageValue = "40"
   )
   void method3737(Buffer var1, int var2) {
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
         this.field3008 = var1.readUnsignedByte();
      } else if(var2 == 13) {
         this.field3011 = var1.readUnsignedShort();
      } else if(var2 == 14) {
         this.field3033 = var1.readUnsignedShort();
      } else if(var2 == 15) {
         this.field3038 = var1.readUnsignedShort();
      } else if(var2 == 16) {
         this.field3019 = var1.readUnsignedShort();
      } else if(var2 == 17) {
         this.field3033 = var1.readUnsignedShort();
         this.field3015 = var1.readUnsignedShort();
         this.field3005 = var1.readUnsignedShort();
         this.field3017 = var1.readUnsignedShort();
      } else if(var2 >= 30 && var2 < 35) {
         this.actions[var2 - 30] = var1.readString();
         if(this.actions[var2 - 30].equalsIgnoreCase("Hidden")) {
            this.actions[var2 - 30] = null;
         }
      } else if(var2 == 40) {
         var3 = var1.readUnsignedByte();
         this.field3018 = new short[var3];
         this.field3014 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3018[var4] = (short)var1.readUnsignedShort();
            this.field3014[var4] = (short)var1.readUnsignedShort();
         }
      } else if(var2 == 41) {
         var3 = var1.readUnsignedByte();
         this.field3020 = new short[var3];
         this.field3021 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3020[var4] = (short)var1.readUnsignedShort();
            this.field3021[var4] = (short)var1.readUnsignedShort();
         }
      } else if(var2 == 60) {
         var3 = var1.readUnsignedByte();
         this.field3010 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3010[var4] = var1.readUnsignedShort();
         }
      } else if(var2 == 93) {
         this.isMinimapVisible = false;
      } else if(var2 == 95) {
         this.combatLevel = var1.readUnsignedShort();
      } else if(var2 == 97) {
         this.field3004 = var1.readUnsignedShort();
      } else if(var2 == 98) {
         this.field3016 = var1.readUnsignedShort();
      } else if(var2 == 99) {
         this.isVisible = true;
      } else if(var2 == 100) {
         this.field3028 = var1.readByte();
      } else if(var2 == 101) {
         this.field3029 = var1.readByte() * 5;
      } else if(var2 == 102) {
         this.field3030 = var1.readUnsignedShort();
      } else if(var2 == 103) {
         this.field3031 = var1.readUnsignedShort();
      } else if(var2 != 106 && var2 != 118) {
         if(var2 == 107) {
            this.field3035 = false;
         } else if(var2 == 109) {
            this.isClickable = false;
         } else if(var2 == 111) {
            this.field3037 = true;
         }
      } else {
         this.field3026 = var1.readUnsignedShort();
         if(this.field3026 == '\uffff') {
            this.field3026 = -1;
         }

         this.field3034 = var1.readUnsignedShort();
         if(this.field3034 == '\uffff') {
            this.field3034 = -1;
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

         this.configs[var4 + 1] = var3;
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass182;Lclass182;I)V",
      garbageValue = "911159505"
   )
   public static void method3742(class182 var0, class182 var1) {
      class88.field1550 = var0;
      Spotanim.field2790 = var1;
   }
}
