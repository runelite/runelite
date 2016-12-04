import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gg")
@Implements("NPCComposition")
public class NPCComposition extends CacheableNode {
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = 1994490537
   )
   int field2992 = -1;
   @ObfuscatedName("d")
   static class182 field2993;
   @ObfuscatedName("m")
   static NodeCache field2994 = new NodeCache(64);
   @ObfuscatedName("h")
   @Export("npcModelCache")
   static NodeCache npcModelCache = new NodeCache(50);
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1330346469
   )
   @Export("id")
   public int id;
   @ObfuscatedName("r")
   @Export("name")
   public String name = "null";
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1599175067
   )
   public int field2998 = -1;
   @ObfuscatedName("n")
   static class182 field2999;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -132712487
   )
   @Export("combatLevel")
   public int combatLevel = -1;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1910517657
   )
   public int field3001 = -1;
   @ObfuscatedName("ag")
   @Export("isClickable")
   public boolean isClickable = true;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1169706137
   )
   public int field3003 = -1;
   @ObfuscatedName("b")
   @Export("actions")
   public String[] actions = new String[5];
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -22069785
   )
   public int field3005 = -1;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1731525569
   )
   public int field3006 = -1;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1645171401
   )
   public int field3007 = -1;
   @ObfuscatedName("g")
   int[] field3008;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -661627919
   )
   public int field3009 = 1;
   @ObfuscatedName("i")
   short[] field3010;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1403751881
   )
   public int field3011 = -1;
   @ObfuscatedName("o")
   short[] field3012;
   @ObfuscatedName("j")
   @Export("isMinimapVisible")
   public boolean isMinimapVisible = true;
   @ObfuscatedName("s")
   short[] field3014;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1347835707
   )
   int field3015 = 128;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 953223649
   )
   int field3016 = 128;
   @ObfuscatedName("t")
   @Export("isVisible")
   public boolean isVisible = false;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = 1091614795
   )
   int field3018 = 0;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = 1682851529
   )
   int field3019 = 0;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = -1841399735
   )
   public int field3020 = -1;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = 1010230557
   )
   public int field3021 = 32;
   @ObfuscatedName("ai")
   public int[] field3022;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = 1878534517
   )
   int field3023 = -1;
   @ObfuscatedName("ae")
   public boolean field3024 = true;
   @ObfuscatedName("p")
   @Export("models")
   int[] models;
   @ObfuscatedName("a")
   short[] field3026;
   @ObfuscatedName("am")
   public boolean field3027 = false;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-1503824000"
   )
   void method3745(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3746(var1, var2);
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-1897475776"
   )
   void method3746(Buffer var1, int var2) {
      int var3;
      int var4;
      if(var2 == 1) {
         var3 = var1.readUnsignedByte();
         this.models = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.models[var4] = var1.readUnsignedShort();
         }
      } else if(var2 == 2) {
         this.name = var1.method3057();
      } else if(var2 == 12) {
         this.field3009 = var1.readUnsignedByte();
      } else if(var2 == 13) {
         this.field3001 = var1.readUnsignedShort();
      } else if(var2 == 14) {
         this.field2998 = var1.readUnsignedShort();
      } else if(var2 == 15) {
         this.field3006 = var1.readUnsignedShort();
      } else if(var2 == 16) {
         this.field3003 = var1.readUnsignedShort();
      } else if(var2 == 17) {
         this.field2998 = var1.readUnsignedShort();
         this.field3005 = var1.readUnsignedShort();
         this.field3011 = var1.readUnsignedShort();
         this.field3007 = var1.readUnsignedShort();
      } else if(var2 >= 30 && var2 < 35) {
         this.actions[var2 - 30] = var1.method3057();
         if(this.actions[var2 - 30].equalsIgnoreCase("Hidden")) {
            this.actions[var2 - 30] = null;
         }
      } else if(var2 == 40) {
         var3 = var1.readUnsignedByte();
         this.field3014 = new short[var3];
         this.field3012 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3014[var4] = (short)var1.readUnsignedShort();
            this.field3012[var4] = (short)var1.readUnsignedShort();
         }
      } else if(var2 == 41) {
         var3 = var1.readUnsignedByte();
         this.field3010 = new short[var3];
         this.field3026 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3010[var4] = (short)var1.readUnsignedShort();
            this.field3026[var4] = (short)var1.readUnsignedShort();
         }
      } else if(var2 == 60) {
         var3 = var1.readUnsignedByte();
         this.field3008 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3008[var4] = var1.readUnsignedShort();
         }
      } else if(var2 == 93) {
         this.isMinimapVisible = false;
      } else if(var2 == 95) {
         this.combatLevel = var1.readUnsignedShort();
      } else if(var2 == 97) {
         this.field3015 = var1.readUnsignedShort();
      } else if(var2 == 98) {
         this.field3016 = var1.readUnsignedShort();
      } else if(var2 == 99) {
         this.isVisible = true;
      } else if(var2 == 100) {
         this.field3018 = var1.readByte();
      } else if(var2 == 101) {
         this.field3019 = var1.readByte() * 5;
      } else if(var2 == 102) {
         this.field3020 = var1.readUnsignedShort();
      } else if(var2 == 103) {
         this.field3021 = var1.readUnsignedShort();
      } else if(var2 != 106 && var2 != 118) {
         if(var2 == 107) {
            this.field3024 = false;
         } else if(var2 == 109) {
            this.isClickable = false;
         } else if(var2 == 111) {
            this.field3027 = true;
         }
      } else {
         this.field3023 = var1.readUnsignedShort();
         if(this.field3023 == '\uffff') {
            this.field3023 = -1;
         }

         this.field2992 = var1.readUnsignedShort();
         if(this.field2992 == '\uffff') {
            this.field2992 = -1;
         }

         var3 = -1;
         if(var2 == 118) {
            var3 = var1.readUnsignedShort();
            if(var3 == '\uffff') {
               var3 = -1;
            }
         }

         var4 = var1.readUnsignedByte();
         this.field3022 = new int[var4 + 2];

         for(int var5 = 0; var5 <= var4; ++var5) {
            this.field3022[var5] = var1.readUnsignedShort();
            if(this.field3022[var5] == '\uffff') {
               this.field3022[var5] = -1;
            }
         }

         this.field3022[var4 + 1] = var3;
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)LModelData;",
      garbageValue = "963080159"
   )
   public final ModelData method3748() {
      if(null != this.field3022) {
         NPCComposition var1 = this.method3770();
         return null == var1?null:var1.method3748();
      } else if(null == this.field3008) {
         return null;
      } else {
         boolean var5 = false;

         for(int var2 = 0; var2 < this.field3008.length; ++var2) {
            if(!field2993.method3347(this.field3008[var2], 0)) {
               var5 = true;
            }
         }

         if(var5) {
            return null;
         } else {
            ModelData[] var6 = new ModelData[this.field3008.length];

            for(int var7 = 0; var7 < this.field3008.length; ++var7) {
               var6[var7] = ModelData.method1491(field2993, this.field3008[var7], 0);
            }

            ModelData var3;
            if(var6.length == 1) {
               var3 = var6[0];
            } else {
               var3 = new ModelData(var6, var6.length);
            }

            int var4;
            if(this.field3014 != null) {
               for(var4 = 0; var4 < this.field3014.length; ++var4) {
                  var3.method1490(this.field3014[var4], this.field3012[var4]);
               }
            }

            if(this.field3010 != null) {
               for(var4 = 0; var4 < this.field3010.length; ++var4) {
                  var3.method1506(this.field3010[var4], this.field3026[var4]);
               }
            }

            return var3;
         }
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "63"
   )
   public boolean method3750() {
      if(this.field3022 == null) {
         return true;
      } else {
         int var1 = -1;
         if(this.field3023 != -1) {
            var1 = class37.method765(this.field3023);
         } else if(this.field2992 != -1) {
            var1 = class146.widgetSettings[this.field2992];
         }

         return var1 >= 0 && var1 < this.field3022.length?this.field3022[var1] != -1:this.field3022[this.field3022.length - 1] != -1;
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-54953810"
   )
   void method3751() {
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(LSequence;ILSequence;IB)LModel;",
      garbageValue = "97"
   )
   public final Model method3756(Sequence var1, int var2, Sequence var3, int var4) {
      if(null != this.field3022) {
         NPCComposition var12 = this.method3770();
         return null == var12?null:var12.method3756(var1, var2, var3, var4);
      } else {
         Model var5 = (Model)npcModelCache.get((long)this.id);
         if(var5 == null) {
            boolean var6 = false;

            for(int var7 = 0; var7 < this.models.length; ++var7) {
               if(!field2993.method3347(this.models[var7], 0)) {
                  var6 = true;
               }
            }

            if(var6) {
               return null;
            }

            ModelData[] var8 = new ModelData[this.models.length];

            int var9;
            for(var9 = 0; var9 < this.models.length; ++var9) {
               var8[var9] = ModelData.method1491(field2993, this.models[var9], 0);
            }

            ModelData var10;
            if(var8.length == 1) {
               var10 = var8[0];
            } else {
               var10 = new ModelData(var8, var8.length);
            }

            if(null != this.field3014) {
               for(var9 = 0; var9 < this.field3014.length; ++var9) {
                  var10.method1490(this.field3014[var9], this.field3012[var9]);
               }
            }

            if(this.field3010 != null) {
               for(var9 = 0; var9 < this.field3010.length; ++var9) {
                  var10.method1506(this.field3010[var9], this.field3026[var9]);
               }
            }

            var5 = var10.method1512(this.field3018 + 64, 850 + this.field3019, -30, -50, -30);
            npcModelCache.put(var5, (long)this.id);
         }

         Model var11;
         if(null != var1 && var3 != null) {
            var11 = var1.method3807(var5, var2, var3, var4);
         } else if(var1 != null) {
            var11 = var1.method3801(var5, var2);
         } else if(var3 != null) {
            var11 = var3.method3801(var5, var4);
         } else {
            var11 = var5.method1582(true);
         }

         if(this.field3015 != 128 || this.field3016 != 128) {
            var11.method1595(this.field3015, this.field3016, this.field3015);
         }

         return var11;
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)LNPCComposition;",
      garbageValue = "128239852"
   )
   public final NPCComposition method3770() {
      int var1 = -1;
      if(this.field3023 != -1) {
         var1 = class37.method765(this.field3023);
      } else if(this.field2992 != -1) {
         var1 = class146.widgetSettings[this.field2992];
      }

      int var2;
      if(var1 >= 0 && var1 < this.field3022.length - 1) {
         var2 = this.field3022[var1];
      } else {
         var2 = this.field3022[this.field3022.length - 1];
      }

      return var2 != -1?class152.getNpcDefinition(var2):null;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "([BB)Lclass208;",
      garbageValue = "0"
   )
   static class208 method3778(byte[] var0) {
      if(var0 == null) {
         return null;
      } else {
         class208 var1 = new class208(var0, class225.field3213, class225.field3214, class225.field3215, class225.field3219, class225.field3210, class225.field3218);
         class189.method3507();
         return var1;
      }
   }
}
