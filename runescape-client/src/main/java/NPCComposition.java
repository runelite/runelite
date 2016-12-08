import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gh")
@Implements("NPCComposition")
public class NPCComposition extends CacheableNode {
   @ObfuscatedName("ah")
   public boolean field2993 = true;
   @ObfuscatedName("m")
   static class182 field2994;
   @ObfuscatedName("b")
   static NodeCache field2995 = new NodeCache(64);
   @ObfuscatedName("e")
   @Export("isVisible")
   public boolean isVisible = false;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1628824977
   )
   @Export("id")
   public int id;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -665383591
   )
   public int field2999 = 1;
   @ObfuscatedName("c")
   @Export("models")
   int[] models;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1619410275
   )
   public int field3002 = -1;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1189769543
   )
   public int field3003 = -1;
   @ObfuscatedName("d")
   short[] field3004;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -120778553
   )
   public int field3005 = -1;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 881637629
   )
   public int field3006 = -1;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1835206751
   )
   public int field3007 = -1;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 808913399
   )
   public int field3008 = -1;
   @ObfuscatedName("s")
   short[] field3009;
   @ObfuscatedName("x")
   short[] field3010;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = 765659185
   )
   public int field3011 = 32;
   @ObfuscatedName("w")
   short[] field3012;
   @ObfuscatedName("n")
   @Export("actions")
   public String[] actions = new String[5];
   @ObfuscatedName("o")
   static class182 field3014;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 497883145
   )
   @Export("combatLevel")
   public int combatLevel = -1;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1344044055
   )
   int field3016 = 128;
   @ObfuscatedName("u")
   int[] field3017;
   @ObfuscatedName("v")
   @Export("name")
   public String name = "null";
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = 1645661455
   )
   int field3019 = 0;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = 1706270481
   )
   int field3020 = 0;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = 846153927
   )
   int field3021 = -1;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1708141927
   )
   int field3022 = 128;
   @ObfuscatedName("ae")
   public int[] field3023;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1957945709
   )
   public int field3024 = -1;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -1056037543
   )
   int field3025 = -1;
   @ObfuscatedName("g")
   @Export("npcModelCache")
   static NodeCache npcModelCache = new NodeCache(50);
   @ObfuscatedName("ak")
   @Export("isClickable")
   public boolean isClickable = true;
   @ObfuscatedName("ab")
   public boolean field3028 = false;
   @ObfuscatedName("q")
   @Export("isMinimapVisible")
   public boolean isMinimapVisible = true;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = 1813936633
   )
   public int field3032 = -1;

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)LModelData;",
      garbageValue = "1268278840"
   )
   public final ModelData method3614() {
      if(null != this.field3023) {
         NPCComposition var1 = this.method3643();
         return null == var1?null:var1.method3614();
      } else if(this.field3017 == null) {
         return null;
      } else {
         boolean var5 = false;

         for(int var7 = 0; var7 < this.field3017.length; ++var7) {
            if(!field2994.method3205(this.field3017[var7], 0)) {
               var5 = true;
            }
         }

         if(var5) {
            return null;
         } else {
            ModelData[] var2 = new ModelData[this.field3017.length];

            for(int var3 = 0; var3 < this.field3017.length; ++var3) {
               var2[var3] = ModelData.method1434(field2994, this.field3017[var3], 0);
            }

            ModelData var6;
            if(var2.length == 1) {
               var6 = var2[0];
            } else {
               var6 = new ModelData(var2, var2.length);
            }

            int var4;
            if(null != this.field3009) {
               for(var4 = 0; var4 < this.field3009.length; ++var4) {
                  var6.method1448(this.field3009[var4], this.field3010[var4]);
               }
            }

            if(null != this.field3004) {
               for(var4 = 0; var4 < this.field3004.length; ++var4) {
                  var6.method1449(this.field3004[var4], this.field3012[var4]);
               }
            }

            return var6;
         }
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-1710017153"
   )
   void method3615(Buffer var1, int var2) {
      int var3;
      int var4;
      if(var2 == 1) {
         var3 = var1.readUnsignedByte();
         this.models = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.models[var4] = var1.readUnsignedShort();
         }
      } else if(var2 == 2) {
         this.name = var1.method2780();
      } else if(var2 == 12) {
         this.field2999 = var1.readUnsignedByte();
      } else if(var2 == 13) {
         this.field3002 = var1.readUnsignedShort();
      } else if(var2 == 14) {
         this.field3005 = var1.readUnsignedShort();
      } else if(var2 == 15) {
         this.field3003 = var1.readUnsignedShort();
      } else if(var2 == 16) {
         this.field3024 = var1.readUnsignedShort();
      } else if(var2 == 17) {
         this.field3005 = var1.readUnsignedShort();
         this.field3006 = var1.readUnsignedShort();
         this.field3007 = var1.readUnsignedShort();
         this.field3008 = var1.readUnsignedShort();
      } else if(var2 >= 30 && var2 < 35) {
         this.actions[var2 - 30] = var1.method2780();
         if(this.actions[var2 - 30].equalsIgnoreCase("Hidden")) {
            this.actions[var2 - 30] = null;
         }
      } else if(var2 == 40) {
         var3 = var1.readUnsignedByte();
         this.field3009 = new short[var3];
         this.field3010 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3009[var4] = (short)var1.readUnsignedShort();
            this.field3010[var4] = (short)var1.readUnsignedShort();
         }
      } else if(var2 == 41) {
         var3 = var1.readUnsignedByte();
         this.field3004 = new short[var3];
         this.field3012 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3004[var4] = (short)var1.readUnsignedShort();
            this.field3012[var4] = (short)var1.readUnsignedShort();
         }
      } else if(var2 == 60) {
         var3 = var1.readUnsignedByte();
         this.field3017 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3017[var4] = var1.readUnsignedShort();
         }
      } else if(var2 == 93) {
         this.isMinimapVisible = false;
      } else if(var2 == 95) {
         this.combatLevel = var1.readUnsignedShort();
      } else if(var2 == 97) {
         this.field3016 = var1.readUnsignedShort();
      } else if(var2 == 98) {
         this.field3022 = var1.readUnsignedShort();
      } else if(var2 == 99) {
         this.isVisible = true;
      } else if(var2 == 100) {
         this.field3019 = var1.readByte();
      } else if(var2 == 101) {
         this.field3020 = var1.readByte() * 5;
      } else if(var2 == 102) {
         this.field3032 = var1.readUnsignedShort();
      } else if(var2 == 103) {
         this.field3011 = var1.readUnsignedShort();
      } else if(var2 != 106 && var2 != 118) {
         if(var2 == 107) {
            this.field2993 = false;
         } else if(var2 == 109) {
            this.isClickable = false;
         } else if(var2 == 111) {
            this.field3028 = true;
         }
      } else {
         this.field3021 = var1.readUnsignedShort();
         if(this.field3021 == '\uffff') {
            this.field3021 = -1;
         }

         this.field3025 = var1.readUnsignedShort();
         if(this.field3025 == '\uffff') {
            this.field3025 = -1;
         }

         var3 = -1;
         if(var2 == 118) {
            var3 = var1.readUnsignedShort();
            if(var3 == '\uffff') {
               var3 = -1;
            }
         }

         var4 = var1.readUnsignedByte();
         this.field3023 = new int[2 + var4];

         for(int var5 = 0; var5 <= var4; ++var5) {
            this.field3023[var5] = var1.readUnsignedShort();
            if(this.field3023[var5] == '\uffff') {
               this.field3023[var5] = -1;
            }
         }

         this.field3023[1 + var4] = var3;
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1223200670"
   )
   void method3617() {
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-229295447"
   )
   public boolean method3618() {
      if(null == this.field3023) {
         return true;
      } else {
         int var1 = -1;
         if(this.field3021 != -1) {
            var1 = XItemContainer.method161(this.field3021);
         } else if(this.field3025 != -1) {
            var1 = class165.widgetSettings[this.field3025];
         }

         return var1 >= 0 && var1 < this.field3023.length?this.field3023[var1] != -1:this.field3023[this.field3023.length - 1] != -1;
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(LSequence;ILSequence;IB)LModel;",
      garbageValue = "37"
   )
   public final Model method3619(Sequence var1, int var2, Sequence var3, int var4) {
      if(this.field3023 != null) {
         NPCComposition var12 = this.method3643();
         return null == var12?null:var12.method3619(var1, var2, var3, var4);
      } else {
         Model var5 = (Model)npcModelCache.get((long)this.id);
         if(null == var5) {
            boolean var6 = false;

            for(int var10 = 0; var10 < this.models.length; ++var10) {
               if(!field2994.method3205(this.models[var10], 0)) {
                  var6 = true;
               }
            }

            if(var6) {
               return null;
            }

            ModelData[] var8 = new ModelData[this.models.length];

            int var9;
            for(var9 = 0; var9 < this.models.length; ++var9) {
               var8[var9] = ModelData.method1434(field2994, this.models[var9], 0);
            }

            ModelData var7;
            if(var8.length == 1) {
               var7 = var8[0];
            } else {
               var7 = new ModelData(var8, var8.length);
            }

            if(this.field3009 != null) {
               for(var9 = 0; var9 < this.field3009.length; ++var9) {
                  var7.method1448(this.field3009[var9], this.field3010[var9]);
               }
            }

            if(null != this.field3004) {
               for(var9 = 0; var9 < this.field3004.length; ++var9) {
                  var7.method1449(this.field3004[var9], this.field3012[var9]);
               }
            }

            var5 = var7.method1465(64 + this.field3019, 850 + this.field3020, -30, -50, -30);
            npcModelCache.put(var5, (long)this.id);
         }

         Model var11;
         if(var1 != null && var3 != null) {
            var11 = var1.method3676(var5, var2, var3, var4);
         } else if(var1 != null) {
            var11 = var1.method3665(var5, var2);
         } else if(null != var3) {
            var11 = var3.method3665(var5, var4);
         } else {
            var11 = var5.method1534(true);
         }

         if(this.field3016 != 128 || this.field3022 != 128) {
            var11.method1537(this.field3016, this.field3022, this.field3016);
         }

         return var11;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-1806169427"
   )
   void method3632(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3615(var1, var2);
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(B)LNPCComposition;",
      garbageValue = "-120"
   )
   public final NPCComposition method3643() {
      int var1 = -1;
      if(this.field3021 != -1) {
         var1 = XItemContainer.method161(this.field3021);
      } else if(this.field3025 != -1) {
         var1 = class165.widgetSettings[this.field3025];
      }

      int var2;
      if(var1 >= 0 && var1 < this.field3023.length - 1) {
         var2 = this.field3023[var1];
      } else {
         var2 = this.field3023[this.field3023.length - 1];
      }

      return var2 != -1?class30.getNpcDefinition(var2):null;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1053845231"
   )
   public static void method3644() {
      if(class185.field2774 != null) {
         class185.field2774.method2027();
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IB)Lclass190;",
      garbageValue = "1"
   )
   public static class190 method3645(int var0) {
      class190 var1 = (class190)class190.field2793.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class190.field2800.method3203(13, var0);
         var1 = new class190();
         var1.field2795 = var0;
         if(var2 != null) {
            var1.method3378(new Buffer(var2));
         }

         class190.field2793.put(var1, (long)var0);
         return var1;
      }
   }
}
