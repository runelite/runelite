import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gw")
@Implements("NPCComposition")
public class NPCComposition extends CacheableNode {
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = 1813585259
   )
   public int field2998 = 32;
   @ObfuscatedName("e")
   public static class182 field2999;
   @ObfuscatedName("f")
   static NodeCache field3000 = new NodeCache(64);
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1886461863
   )
   public int field3001 = -1;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 747289411
   )
   public int field3002 = -1;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -397655407
   )
   public int field3003 = -1;
   @ObfuscatedName("i")
   public static class182 field3004;
   @ObfuscatedName("n")
   @Export("name")
   public String name = "null";
   @ObfuscatedName("w")
   int[] field3006;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1390026499
   )
   public int field3007 = -1;
   @ObfuscatedName("o")
   @Export("isVisible")
   public boolean isVisible = false;
   @ObfuscatedName("aw")
   public boolean field3009 = true;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 799732181
   )
   public int field3010 = -1;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -527885627
   )
   public int field3011 = -1;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -248745063
   )
   public int field3012 = 1;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1616075407
   )
   public int field3013 = -1;
   @ObfuscatedName("u")
   short[] field3014;
   @ObfuscatedName("j")
   short[] field3015;
   @ObfuscatedName("x")
   short[] field3016;
   @ObfuscatedName("d")
   short[] field3017;
   @ObfuscatedName("y")
   @Export("actions")
   public String[] actions = new String[5];
   @ObfuscatedName("s")
   @Export("isMinimapVisible")
   public boolean isMinimapVisible = true;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1971857275
   )
   @Export("combatLevel")
   public int combatLevel = -1;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1462572857
   )
   int field3021 = 128;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1588055761
   )
   int field3022 = 128;
   @ObfuscatedName("q")
   @Export("models")
   int[] models;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = 1085346067
   )
   int field3024 = 0;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = 837993235
   )
   int field3025 = 0;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -2097080157
   )
   @Export("id")
   public int id;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = 349234017
   )
   public int field3027 = -1;
   @ObfuscatedName("ay")
   public int[] field3028;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = 1147324877
   )
   int field3029 = -1;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = -1454740463
   )
   int field3030 = -1;
   @ObfuscatedName("k")
   @Export("npcModelCache")
   static NodeCache npcModelCache = new NodeCache(50);
   @ObfuscatedName("am")
   @Export("isClickable")
   public boolean isClickable = true;
   @ObfuscatedName("av")
   public boolean field3033 = false;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "1641679594"
   )
   void method3630(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3631(var1, var2);
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "821568788"
   )
   void method3631(Buffer var1, int var2) {
      int var3;
      int var4;
      if(var2 == 1) {
         var3 = var1.readUnsignedByte();
         this.models = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.models[var4] = var1.readUnsignedShort();
         }
      } else if(var2 == 2) {
         this.name = var1.method2767();
      } else if(var2 == 12) {
         this.field3012 = var1.readUnsignedByte();
      } else if(var2 == 13) {
         this.field3007 = var1.readUnsignedShort();
      } else if(var2 == 14) {
         this.field3003 = var1.readUnsignedShort();
      } else if(var2 == 15) {
         this.field3002 = var1.readUnsignedShort();
      } else if(var2 == 16) {
         this.field3010 = var1.readUnsignedShort();
      } else if(var2 == 17) {
         this.field3003 = var1.readUnsignedShort();
         this.field3011 = var1.readUnsignedShort();
         this.field3001 = var1.readUnsignedShort();
         this.field3013 = var1.readUnsignedShort();
      } else if(var2 >= 30 && var2 < 35) {
         this.actions[var2 - 30] = var1.method2767();
         if(this.actions[var2 - 30].equalsIgnoreCase("Hidden")) {
            this.actions[var2 - 30] = null;
         }
      } else if(var2 == 40) {
         var3 = var1.readUnsignedByte();
         this.field3014 = new short[var3];
         this.field3015 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3014[var4] = (short)var1.readUnsignedShort();
            this.field3015[var4] = (short)var1.readUnsignedShort();
         }
      } else if(var2 == 41) {
         var3 = var1.readUnsignedByte();
         this.field3016 = new short[var3];
         this.field3017 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3016[var4] = (short)var1.readUnsignedShort();
            this.field3017[var4] = (short)var1.readUnsignedShort();
         }
      } else if(var2 == 60) {
         var3 = var1.readUnsignedByte();
         this.field3006 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3006[var4] = var1.readUnsignedShort();
         }
      } else if(var2 == 93) {
         this.isMinimapVisible = false;
      } else if(var2 == 95) {
         this.combatLevel = var1.readUnsignedShort();
      } else if(var2 == 97) {
         this.field3021 = var1.readUnsignedShort();
      } else if(var2 == 98) {
         this.field3022 = var1.readUnsignedShort();
      } else if(var2 == 99) {
         this.isVisible = true;
      } else if(var2 == 100) {
         this.field3024 = var1.readByte();
      } else if(var2 == 101) {
         this.field3025 = var1.readByte() * 5;
      } else if(var2 == 102) {
         this.field3027 = var1.readUnsignedShort();
      } else if(var2 == 103) {
         this.field2998 = var1.readUnsignedShort();
      } else if(var2 != 106 && var2 != 118) {
         if(var2 == 107) {
            this.field3009 = false;
         } else if(var2 == 109) {
            this.isClickable = false;
         } else if(var2 == 111) {
            this.field3033 = true;
         }
      } else {
         this.field3029 = var1.readUnsignedShort();
         if(this.field3029 == '\uffff') {
            this.field3029 = -1;
         }

         this.field3030 = var1.readUnsignedShort();
         if(this.field3030 == '\uffff') {
            this.field3030 = -1;
         }

         var3 = -1;
         if(var2 == 118) {
            var3 = var1.readUnsignedShort();
            if(var3 == '\uffff') {
               var3 = -1;
            }
         }

         var4 = var1.readUnsignedByte();
         this.field3028 = new int[var4 + 2];

         for(int var5 = 0; var5 <= var4; ++var5) {
            this.field3028[var5] = var1.readUnsignedShort();
            if(this.field3028[var5] == '\uffff') {
               this.field3028[var5] = -1;
            }
         }

         this.field3028[1 + var4] = var3;
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(LSequence;ILSequence;IB)LModel;",
      garbageValue = "-2"
   )
   public final Model method3634(Sequence var1, int var2, Sequence var3, int var4) {
      if(this.field3028 != null) {
         NPCComposition var12 = this.method3635();
         return var12 == null?null:var12.method3634(var1, var2, var3, var4);
      } else {
         Model var5 = (Model)npcModelCache.get((long)this.id);
         if(null == var5) {
            boolean var10 = false;

            for(int var7 = 0; var7 < this.models.length; ++var7) {
               if(!field2999.method3213(this.models[var7], 0)) {
                  var10 = true;
               }
            }

            if(var10) {
               return null;
            }

            ModelData[] var8 = new ModelData[this.models.length];

            int var9;
            for(var9 = 0; var9 < this.models.length; ++var9) {
               var8[var9] = ModelData.method1452(field2999, this.models[var9], 0);
            }

            ModelData var11;
            if(var8.length == 1) {
               var11 = var8[0];
            } else {
               var11 = new ModelData(var8, var8.length);
            }

            if(null != this.field3014) {
               for(var9 = 0; var9 < this.field3014.length; ++var9) {
                  var11.method1483(this.field3014[var9], this.field3015[var9]);
               }
            }

            if(null != this.field3016) {
               for(var9 = 0; var9 < this.field3016.length; ++var9) {
                  var11.method1476(this.field3016[var9], this.field3017[var9]);
               }
            }

            var5 = var11.method1480(this.field3024 + 64, 850 + this.field3025, -30, -50, -30);
            npcModelCache.put(var5, (long)this.id);
         }

         Model var6;
         if(var1 != null && var3 != null) {
            var6 = var1.method3684(var5, var2, var3, var4);
         } else if(var1 != null) {
            var6 = var1.method3681(var5, var2);
         } else if(var3 != null) {
            var6 = var3.method3681(var5, var4);
         } else {
            var6 = var5.method1541(true);
         }

         if(this.field3021 != 128 || this.field3022 != 128) {
            var6.method1555(this.field3021, this.field3022, this.field3021);
         }

         return var6;
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)LNPCComposition;",
      garbageValue = "2084702136"
   )
   public final NPCComposition method3635() {
      int var1 = -1;
      if(this.field3029 != -1) {
         var1 = class97.method1898(this.field3029);
      } else if(this.field3030 != -1) {
         var1 = class165.widgetSettings[this.field3030];
      }

      int var2;
      if(var1 >= 0 && var1 < this.field3028.length - 1) {
         var2 = this.field3028[var1];
      } else {
         var2 = this.field3028[this.field3028.length - 1];
      }

      return var2 != -1?TextureProvider.getNpcDefinition(var2):null;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1650326167"
   )
   public boolean method3637() {
      if(this.field3028 == null) {
         return true;
      } else {
         int var1 = -1;
         if(this.field3029 != -1) {
            var1 = class97.method1898(this.field3029);
         } else if(this.field3030 != -1) {
            var1 = class165.widgetSettings[this.field3030];
         }

         return var1 >= 0 && var1 < this.field3028.length?this.field3028[var1] != -1:this.field3028[this.field3028.length - 1] != -1;
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "436341259"
   )
   void method3653() {
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(B)LModelData;",
      garbageValue = "1"
   )
   public final ModelData method3654() {
      if(this.field3028 != null) {
         NPCComposition var1 = this.method3635();
         return null == var1?null:var1.method3654();
      } else if(this.field3006 == null) {
         return null;
      } else {
         boolean var6 = false;

         for(int var5 = 0; var5 < this.field3006.length; ++var5) {
            if(!field2999.method3213(this.field3006[var5], 0)) {
               var6 = true;
            }
         }

         if(var6) {
            return null;
         } else {
            ModelData[] var2 = new ModelData[this.field3006.length];

            for(int var7 = 0; var7 < this.field3006.length; ++var7) {
               var2[var7] = ModelData.method1452(field2999, this.field3006[var7], 0);
            }

            ModelData var3;
            if(var2.length == 1) {
               var3 = var2[0];
            } else {
               var3 = new ModelData(var2, var2.length);
            }

            int var4;
            if(null != this.field3014) {
               for(var4 = 0; var4 < this.field3014.length; ++var4) {
                  var3.method1483(this.field3014[var4], this.field3015[var4]);
               }
            }

            if(null != this.field3016) {
               for(var4 = 0; var4 < this.field3016.length; ++var4) {
                  var3.method1476(this.field3016[var4], this.field3017[var4]);
               }
            }

            return var3;
         }
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;S)Ljava/lang/String;",
      garbageValue = "6537"
   )
   public static String method3660(CharSequence var0) {
      String var1 = class172.method3177(class110.method2047(var0));
      if(null == var1) {
         var1 = "";
      }

      return var1;
   }
}
