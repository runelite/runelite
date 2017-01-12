import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gq")
@Implements("NPCComposition")
public class NPCComposition extends CacheableNode {
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -753711883
   )
   public int field2987 = -1;
   @ObfuscatedName("i")
   static NodeCache field2988 = new NodeCache(64);
   @ObfuscatedName("a")
   @Export("npcModelCache")
   static NodeCache npcModelCache = new NodeCache(50);
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1473747213
   )
   @Export("id")
   public int id;
   @ObfuscatedName("c")
   @Export("name")
   public String name = "null";
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 927697085
   )
   public int field2992 = -1;
   @ObfuscatedName("l")
   @Export("models")
   int[] models;
   @ObfuscatedName("g")
   int[] field2994;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 586204835
   )
   public int field2995 = -1;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = 1990081287
   )
   int field2996 = 0;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 414634061
   )
   public int field2997 = -1;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = 1016150827
   )
   int field2998 = 0;
   @ObfuscatedName("y")
   short[] field2999;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 395458649
   )
   public int field3000 = -1;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 842376905
   )
   public int field3001 = -1;
   @ObfuscatedName("u")
   static class182 field3002;
   @ObfuscatedName("k")
   short[] field3003;
   @ObfuscatedName("r")
   short[] field3004;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1672661577
   )
   int field3005 = 128;
   @ObfuscatedName("h")
   @Export("actions")
   public String[] actions = new String[5];
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -255884503
   )
   public int field3007 = 1;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -197832653
   )
   @Export("combatLevel")
   public int combatLevel = -1;
   @ObfuscatedName("ai")
   public boolean field3009 = true;
   @ObfuscatedName("s")
   @Export("isMinimapVisible")
   public boolean isMinimapVisible = true;
   @ObfuscatedName("b")
   @Export("isVisible")
   public boolean isVisible = false;
   @ObfuscatedName("p")
   short[] field3012;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 855005259
   )
   int field3013 = 128;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = -1554103139
   )
   public int field3014 = -1;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = 825508189
   )
   public int field3015 = 32;
   @ObfuscatedName("af")
   public int[] field3016;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = 1640811235
   )
   int field3017 = -1;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = 281744451
   )
   int field3018 = -1;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -344471911
   )
   public int field3019 = -1;
   @ObfuscatedName("ah")
   @Export("isClickable")
   public boolean isClickable = true;
   @ObfuscatedName("av")
   public boolean field3021 = false;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(LSequence;ILSequence;II)LModel;",
      garbageValue = "-1839929379"
   )
   public final Model method3701(Sequence var1, int var2, Sequence var3, int var4) {
      if(null != this.field3016) {
         NPCComposition var12 = this.method3705();
         return var12 == null?null:var12.method3701(var1, var2, var3, var4);
      } else {
         Model var5 = (Model)npcModelCache.get((long)this.id);
         if(null == var5) {
            boolean var10 = false;

            for(int var11 = 0; var11 < this.models.length; ++var11) {
               if(!Widget.field2321.method3264(this.models[var11], 0)) {
                  var10 = true;
               }
            }

            if(var10) {
               return null;
            }

            ModelData[] var8 = new ModelData[this.models.length];

            int var9;
            for(var9 = 0; var9 < this.models.length; ++var9) {
               var8[var9] = ModelData.method1463(Widget.field2321, this.models[var9], 0);
            }

            ModelData var7;
            if(var8.length == 1) {
               var7 = var8[0];
            } else {
               var7 = new ModelData(var8, var8.length);
            }

            if(this.field3012 != null) {
               for(var9 = 0; var9 < this.field3012.length; ++var9) {
                  var7.method1427(this.field3012[var9], this.field3003[var9]);
               }
            }

            if(null != this.field3004) {
               for(var9 = 0; var9 < this.field3004.length; ++var9) {
                  var7.method1469(this.field3004[var9], this.field2999[var9]);
               }
            }

            var5 = var7.method1486(this.field2998 + 64, this.field2996 + 850, -30, -50, -30);
            npcModelCache.put(var5, (long)this.id);
         }

         Model var6;
         if(var1 != null && var3 != null) {
            var6 = var1.method3755(var5, var2, var3, var4);
         } else if(null != var1) {
            var6 = var1.method3764(var5, var2);
         } else if(var3 != null) {
            var6 = var3.method3764(var5, var4);
         } else {
            var6 = var5.method1557(true);
         }

         if(this.field3013 != 128 || this.field3005 != 128) {
            var6.method1514(this.field3013, this.field3005, this.field3013);
         }

         return var6;
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "1279256210"
   )
   void method3702(Buffer var1, int var2) {
      int var3;
      int var4;
      if(var2 == 1) {
         var3 = var1.readUnsignedByte();
         this.models = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.models[var4] = var1.readUnsignedShort();
         }
      } else if(var2 == 2) {
         this.name = var1.method2965();
      } else if(var2 == 12) {
         this.field3007 = var1.readUnsignedByte();
      } else if(var2 == 13) {
         this.field2992 = var1.readUnsignedShort();
      } else if(var2 == 14) {
         this.field3000 = var1.readUnsignedShort();
      } else if(var2 == 15) {
         this.field2987 = var1.readUnsignedShort();
      } else if(var2 == 16) {
         this.field2997 = var1.readUnsignedShort();
      } else if(var2 == 17) {
         this.field3000 = var1.readUnsignedShort();
         this.field3019 = var1.readUnsignedShort();
         this.field2995 = var1.readUnsignedShort();
         this.field3001 = var1.readUnsignedShort();
      } else if(var2 >= 30 && var2 < 35) {
         this.actions[var2 - 30] = var1.method2965();
         if(this.actions[var2 - 30].equalsIgnoreCase("Hidden")) {
            this.actions[var2 - 30] = null;
         }
      } else if(var2 == 40) {
         var3 = var1.readUnsignedByte();
         this.field3012 = new short[var3];
         this.field3003 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3012[var4] = (short)var1.readUnsignedShort();
            this.field3003[var4] = (short)var1.readUnsignedShort();
         }
      } else if(var2 == 41) {
         var3 = var1.readUnsignedByte();
         this.field3004 = new short[var3];
         this.field2999 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3004[var4] = (short)var1.readUnsignedShort();
            this.field2999[var4] = (short)var1.readUnsignedShort();
         }
      } else if(var2 == 60) {
         var3 = var1.readUnsignedByte();
         this.field2994 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field2994[var4] = var1.readUnsignedShort();
         }
      } else if(var2 == 93) {
         this.isMinimapVisible = false;
      } else if(var2 == 95) {
         this.combatLevel = var1.readUnsignedShort();
      } else if(var2 == 97) {
         this.field3013 = var1.readUnsignedShort();
      } else if(var2 == 98) {
         this.field3005 = var1.readUnsignedShort();
      } else if(var2 == 99) {
         this.isVisible = true;
      } else if(var2 == 100) {
         this.field2998 = var1.readByte();
      } else if(var2 == 101) {
         this.field2996 = var1.readByte() * 5;
      } else if(var2 == 102) {
         this.field3014 = var1.readUnsignedShort();
      } else if(var2 == 103) {
         this.field3015 = var1.readUnsignedShort();
      } else if(var2 != 106 && var2 != 118) {
         if(var2 == 107) {
            this.field3009 = false;
         } else if(var2 == 109) {
            this.isClickable = false;
         } else if(var2 == 111) {
            this.field3021 = true;
         }
      } else {
         this.field3017 = var1.readUnsignedShort();
         if(this.field3017 == '\uffff') {
            this.field3017 = -1;
         }

         this.field3018 = var1.readUnsignedShort();
         if(this.field3018 == '\uffff') {
            this.field3018 = -1;
         }

         var3 = -1;
         if(var2 == 118) {
            var3 = var1.readUnsignedShort();
            if(var3 == '\uffff') {
               var3 = -1;
            }
         }

         var4 = var1.readUnsignedByte();
         this.field3016 = new int[var4 + 2];

         for(int var5 = 0; var5 <= var4; ++var5) {
            this.field3016[var5] = var1.readUnsignedShort();
            if(this.field3016[var5] == '\uffff') {
               this.field3016[var5] = -1;
            }
         }

         this.field3016[var4 + 1] = var3;
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)LModelData;",
      garbageValue = "-1946864212"
   )
   public final ModelData method3704() {
      if(this.field3016 != null) {
         NPCComposition var1 = this.method3705();
         return var1 == null?null:var1.method3704();
      } else if(this.field2994 == null) {
         return null;
      } else {
         boolean var5 = false;

         for(int var2 = 0; var2 < this.field2994.length; ++var2) {
            if(!Widget.field2321.method3264(this.field2994[var2], 0)) {
               var5 = true;
            }
         }

         if(var5) {
            return null;
         } else {
            ModelData[] var7 = new ModelData[this.field2994.length];

            for(int var6 = 0; var6 < this.field2994.length; ++var6) {
               var7[var6] = ModelData.method1463(Widget.field2321, this.field2994[var6], 0);
            }

            ModelData var3;
            if(var7.length == 1) {
               var3 = var7[0];
            } else {
               var3 = new ModelData(var7, var7.length);
            }

            int var4;
            if(null != this.field3012) {
               for(var4 = 0; var4 < this.field3012.length; ++var4) {
                  var3.method1427(this.field3012[var4], this.field3003[var4]);
               }
            }

            if(this.field3004 != null) {
               for(var4 = 0; var4 < this.field3004.length; ++var4) {
                  var3.method1469(this.field3004[var4], this.field2999[var4]);
               }
            }

            return var3;
         }
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)LNPCComposition;",
      garbageValue = "-906405206"
   )
   public final NPCComposition method3705() {
      int var1 = -1;
      if(this.field3017 != -1) {
         var1 = class101.method1911(this.field3017);
      } else if(this.field3018 != -1) {
         var1 = class165.widgetSettings[this.field3018];
      }

      int var2;
      if(var1 >= 0 && var1 < this.field3016.length - 1) {
         var2 = this.field3016[var1];
      } else {
         var2 = this.field3016[this.field3016.length - 1];
      }

      return var2 != -1?Actor.getNpcDefinition(var2):null;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1060453075"
   )
   public boolean method3706() {
      if(null == this.field3016) {
         return true;
      } else {
         int var1 = -1;
         if(this.field3017 != -1) {
            var1 = class101.method1911(this.field3017);
         } else if(this.field3018 != -1) {
            var1 = class165.widgetSettings[this.field3018];
         }

         return var1 >= 0 && var1 < this.field3016.length?this.field3016[var1] != -1:this.field3016[this.field3016.length - 1] != -1;
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "0"
   )
   void method3710(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3702(var1, var2);
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-897458117"
   )
   void method3715() {
   }
}
