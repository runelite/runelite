import java.awt.Container;
import java.awt.Insets;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gy")
@Implements("ItemComposition")
public class ItemComposition extends CacheableNode {
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -942551629
   )
   public int field2940 = 0;
   @ObfuscatedName("h")
   public static class182 field2942;
   @ObfuscatedName("r")
   @Export("isMembersWorld")
   public static boolean isMembersWorld;
   @ObfuscatedName("e")
   @Export("name")
   public String name = "null";
   @ObfuscatedName("p")
   public static NodeCache field2945 = new NodeCache(64);
   @ObfuscatedName("z")
   @Export("itemSpriteCache")
   public static NodeCache itemSpriteCache = new NodeCache(200);
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1143491675
   )
   @Export("id")
   public int id;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = -1687073639
   )
   int field2948 = -1;
   @ObfuscatedName("f")
   short[] field2949;
   @ObfuscatedName("x")
   short[] field2950;
   @ObfuscatedName("g")
   @Export("itemModelCache")
   public static NodeCache itemModelCache = new NodeCache(50);
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 430171405
   )
   public int field2952 = 2000;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = -921978819
   )
   int field2953 = -1;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1632671797
   )
   int field2954;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1401043671
   )
   public int field2955 = 0;
   @ObfuscatedName("bn")
   @ObfuscatedGetter(
      intValue = 1108475205
   )
   int field2957 = -1;
   @ObfuscatedName("bv")
   @ObfuscatedGetter(
      intValue = 1022323771
   )
   public int field2958 = -1;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 896971955
   )
   public int field2959 = 0;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 376000901
   )
   @Export("isStackable")
   public int isStackable = 0;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -964037849
   )
   @Export("price")
   public int price = 1;
   @ObfuscatedName("av")
   @Export("isMembers")
   public boolean isMembers = false;
   @ObfuscatedName("aw")
   @Export("groundActions")
   public String[] groundActions = new String[]{null, null, "Take", null, null};
   @ObfuscatedName("ay")
   @Export("inventoryActions")
   public String[] inventoryActions = new String[]{null, null, null, null, "Drop"};
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = 1597082683
   )
   public int field2965 = 0;
   @ObfuscatedName("ad")
   int[] field2966;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = 168710837
   )
   int field2967 = 0;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = 1807318039
   )
   int field2968 = -1;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = -1338833533
   )
   int field2969 = -1;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = -22323303
   )
   int field2970 = 0;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = -1466539369
   )
   int field2971 = -1;
   @ObfuscatedName("bt")
   @ObfuscatedGetter(
      intValue = -968361483
   )
   int field2972 = -1;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = 1170335879
   )
   @Export("maleModel")
   int maleModel = -1;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = -998106739
   )
   int field2974 = -1;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = 1764722213
   )
   int field2975 = -1;
   @ObfuscatedName("o")
   short[] field2976;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 595337681
   )
   public int field2977 = 0;
   @ObfuscatedName("ah")
   int[] field2978;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = 150745941
   )
   @Export("note")
   public int note = -1;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = 1834291871
   )
   public int field2980 = -1;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = -1453767635
   )
   int field2981 = 128;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -46507639
   )
   public int field2982 = 0;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = -1055117327
   )
   int field2983 = 128;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = -334253905
   )
   int field2984 = 128;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = -1975377171
   )
   public int field2985 = 0;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = -2094751907
   )
   public int field2986 = 0;
   @ObfuscatedName("ao")
   public boolean field2987 = false;
   @ObfuscatedName("s")
   short[] field2988;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = 1506657383
   )
   int field2989 = -1;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = -357418271
   )
   int field2990 = -1;
   @ObfuscatedName("bd")
   @ObfuscatedGetter(
      intValue = 52678159
   )
   public int field2991 = -1;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(LItemComposition;LItemComposition;I)V",
      garbageValue = "1076544451"
   )
   void method3690(ItemComposition var1, ItemComposition var2) {
      this.field2954 = var1.field2954;
      this.field2952 = var1.field2952;
      this.field2955 = var1.field2955;
      this.field2982 = var1.field2982;
      this.field2977 = var1.field2977;
      this.field2940 = var1.field2940;
      this.field2959 = var1.field2959;
      this.field2950 = var1.field2950;
      this.field2949 = var1.field2949;
      this.field2988 = var1.field2988;
      this.field2976 = var1.field2976;
      this.isStackable = var1.isStackable;
      this.name = var2.name;
      this.price = 0;
      this.isMembers = false;
      this.field2987 = false;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "88"
   )
   void method3691() {
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "1325318348"
   )
   @Export("populateFromBuffer")
   void populateFromBuffer(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field2954 = var1.method3097();
      } else if(var2 == 2) {
         this.name = var1.method3057();
      } else if(var2 == 4) {
         this.field2952 = var1.method3097();
      } else if(var2 == 5) {
         this.field2955 = var1.method3097();
      } else if(var2 == 6) {
         this.field2982 = var1.method3097();
      } else if(var2 == 7) {
         this.field2940 = var1.method3097();
         if(this.field2940 > 32767) {
            this.field2940 -= 65536;
         }
      } else if(var2 == 8) {
         this.field2959 = var1.method3097();
         if(this.field2959 > 32767) {
            this.field2959 -= 65536;
         }
      } else if(var2 == 11) {
         this.isStackable = 1;
      } else if(var2 == 12) {
         this.price = var1.method2995();
      } else if(var2 == 16) {
         this.isMembers = true;
      } else if(var2 == 23) {
         this.field2974 = var1.method3097();
         this.field2967 = var1.method3033();
      } else if(var2 == 24) {
         this.field2989 = var1.method3097();
      } else if(var2 == 25) {
         this.field2968 = var1.method3097();
         this.field2970 = var1.method3033();
      } else if(var2 == 26) {
         this.field2969 = var1.method3097();
      } else if(var2 >= 30 && var2 < 35) {
         this.groundActions[var2 - 30] = var1.method3057();
         if(this.groundActions[var2 - 30].equalsIgnoreCase("Hidden")) {
            this.groundActions[var2 - 30] = null;
         }
      } else if(var2 >= 35 && var2 < 40) {
         this.inventoryActions[var2 - 35] = var1.method3057();
      } else {
         int var3;
         int var4;
         if(var2 == 40) {
            var3 = var1.method3033();
            this.field2950 = new short[var3];
            this.field2949 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field2950[var4] = (short)var1.method3097();
               this.field2949[var4] = (short)var1.method3097();
            }
         } else if(var2 == 41) {
            var3 = var1.method3033();
            this.field2988 = new short[var3];
            this.field2976 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field2988[var4] = (short)var1.method3097();
               this.field2976[var4] = (short)var1.method3097();
            }
         } else if(var2 == 65) {
            this.field2987 = true;
         } else if(var2 == 78) {
            this.field2971 = var1.method3097();
         } else if(var2 == 79) {
            this.field2990 = var1.method3097();
         } else if(var2 == 90) {
            this.maleModel = var1.method3097();
         } else if(var2 == 91) {
            this.field2948 = var1.method3097();
         } else if(var2 == 92) {
            this.field2953 = var1.method3097();
         } else if(var2 == 93) {
            this.field2975 = var1.method3097();
         } else if(var2 == 95) {
            this.field2977 = var1.method3097();
         } else if(var2 == 97) {
            this.note = var1.method3097();
         } else if(var2 == 98) {
            this.field2980 = var1.method3097();
         } else if(var2 >= 100 && var2 < 110) {
            if(null == this.field2966) {
               this.field2966 = new int[10];
               this.field2978 = new int[10];
            }

            this.field2966[var2 - 100] = var1.method3097();
            this.field2978[var2 - 100] = var1.method3097();
         } else if(var2 == 110) {
            this.field2981 = var1.method3097();
         } else if(var2 == 111) {
            this.field2984 = var1.method3097();
         } else if(var2 == 112) {
            this.field2983 = var1.method3097();
         } else if(var2 == 113) {
            this.field2965 = var1.method3047();
         } else if(var2 == 114) {
            this.field2985 = var1.method3047() * 5;
         } else if(var2 == 115) {
            this.field2986 = var1.method3033();
         } else if(var2 == 139) {
            this.field2957 = var1.method3097();
         } else if(var2 == 140) {
            this.field2972 = var1.method3097();
         } else if(var2 == 148) {
            this.field2958 = var1.method3097();
         } else if(var2 == 149) {
            this.field2991 = var1.method3097();
         }
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(LItemComposition;LItemComposition;B)V",
      garbageValue = "83"
   )
   void method3694(ItemComposition var1, ItemComposition var2) {
      this.field2954 = var1.field2954;
      this.field2952 = var1.field2952;
      this.field2955 = var1.field2955;
      this.field2982 = var1.field2982;
      this.field2977 = var1.field2977;
      this.field2940 = var1.field2940;
      this.field2959 = var1.field2959;
      this.field2950 = var1.field2950;
      this.field2949 = var1.field2949;
      this.field2988 = var1.field2988;
      this.field2976 = var1.field2976;
      this.name = var2.name;
      this.isMembers = var2.isMembers;
      this.price = var2.price;
      this.isStackable = 1;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(LItemComposition;LItemComposition;I)V",
      garbageValue = "-1381893257"
   )
   void method3695(ItemComposition var1, ItemComposition var2) {
      this.field2954 = var1.field2954;
      this.field2952 = var1.field2952;
      this.field2955 = var1.field2955;
      this.field2982 = var1.field2982;
      this.field2977 = var1.field2977;
      this.field2940 = var1.field2940;
      this.field2959 = var1.field2959;
      this.field2950 = var2.field2950;
      this.field2949 = var2.field2949;
      this.field2988 = var2.field2988;
      this.field2976 = var2.field2976;
      this.name = var2.name;
      this.isMembers = var2.isMembers;
      this.isStackable = var2.isStackable;
      this.field2974 = var2.field2974;
      this.field2989 = var2.field2989;
      this.field2971 = var2.field2971;
      this.field2968 = var2.field2968;
      this.field2969 = var2.field2969;
      this.field2990 = var2.field2990;
      this.maleModel = var2.maleModel;
      this.field2953 = var2.field2953;
      this.field2948 = var2.field2948;
      this.field2975 = var2.field2975;
      this.field2986 = var2.field2986;
      this.groundActions = var2.groundActions;
      this.inventoryActions = new String[5];
      if(null != var2.inventoryActions) {
         for(int var3 = 0; var3 < 4; ++var3) {
            this.inventoryActions[var3] = var2.inventoryActions[var3];
         }
      }

      this.inventoryActions[4] = "Discard";
      this.price = 0;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-1257815806"
   )
   @Export("loadBuffer")
   void loadBuffer(Buffer var1) {
      while(true) {
         int var2 = var1.method3033();
         if(var2 == 0) {
            return;
         }

         this.populateFromBuffer(var1, var2);
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(ZI)Z",
      garbageValue = "494697370"
   )
   @Export("readyWorn")
   public final boolean readyWorn(boolean var1) {
      int var2 = this.field2974;
      int var3 = this.field2989;
      int var4 = this.field2971;
      if(var1) {
         var2 = this.field2968;
         var3 = this.field2969;
         var4 = this.field2990;
      }

      if(var2 == -1) {
         return true;
      } else {
         boolean var5 = true;
         if(!class172.field2367.method3347(var2, 0)) {
            var5 = false;
         }

         if(var3 != -1 && !class172.field2367.method3347(var3, 0)) {
            var5 = false;
         }

         if(var4 != -1 && !class172.field2367.method3347(var4, 0)) {
            var5 = false;
         }

         return var5;
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(ZB)LModelData;",
      garbageValue = "6"
   )
   @Export("getWornModelData")
   public final ModelData getWornModelData(boolean var1) {
      int var2 = this.field2974;
      int var3 = this.field2989;
      int var4 = this.field2971;
      if(var1) {
         var2 = this.field2968;
         var3 = this.field2969;
         var4 = this.field2990;
      }

      if(var2 == -1) {
         return null;
      } else {
         ModelData var5 = ModelData.method1491(class172.field2367, var2, 0);
         if(var3 != -1) {
            ModelData var9 = ModelData.method1491(class172.field2367, var3, 0);
            if(var4 != -1) {
               ModelData var7 = ModelData.method1491(class172.field2367, var4, 0);
               ModelData[] var8 = new ModelData[]{var5, var9, var7};
               var5 = new ModelData(var8, 3);
            } else {
               ModelData[] var10 = new ModelData[]{var5, var9};
               var5 = new ModelData(var10, 2);
            }
         }

         if(!var1 && this.field2967 != 0) {
            var5.method1504(0, this.field2967, 0);
         }

         if(var1 && this.field2970 != 0) {
            var5.method1504(0, this.field2970, 0);
         }

         int var6;
         if(null != this.field2950) {
            for(var6 = 0; var6 < this.field2950.length; ++var6) {
               var5.method1490(this.field2950[var6], this.field2949[var6]);
            }
         }

         if(null != this.field2988) {
            for(var6 = 0; var6 < this.field2988.length; ++var6) {
               var5.method1506(this.field2988[var6], this.field2976[var6]);
            }
         }

         return var5;
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(ZS)LModelData;",
      garbageValue = "3576"
   )
   public final ModelData method3703(boolean var1) {
      int var2 = this.maleModel;
      int var3 = this.field2953;
      if(var1) {
         var2 = this.field2948;
         var3 = this.field2975;
      }

      if(var2 == -1) {
         return null;
      } else {
         ModelData var4 = ModelData.method1491(class172.field2367, var2, 0);
         if(var3 != -1) {
            ModelData var7 = ModelData.method1491(class172.field2367, var3, 0);
            ModelData[] var6 = new ModelData[]{var4, var7};
            var4 = new ModelData(var6, 2);
         }

         int var5;
         if(this.field2950 != null) {
            for(var5 = 0; var5 < this.field2950.length; ++var5) {
               var4.method1490(this.field2950[var5], this.field2949[var5]);
            }
         }

         if(null != this.field2988) {
            for(var5 = 0; var5 < this.field2988.length; ++var5) {
               var4.method1506(this.field2988[var5], this.field2976[var5]);
            }
         }

         return var4;
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)LModel;",
      garbageValue = "1050750478"
   )
   @Export("getModel")
   public final Model getModel(int var1) {
      if(this.field2966 != null && var1 > 1) {
         int var2 = -1;

         for(int var3 = 0; var3 < 10; ++var3) {
            if(var1 >= this.field2978[var3] && this.field2978[var3] != 0) {
               var2 = this.field2966[var3];
            }
         }

         if(var2 != -1) {
            return class18.getItemDefinition(var2).getModel(1);
         }
      }

      Model var6 = (Model)itemModelCache.get((long)this.id);
      if(null != var6) {
         return var6;
      } else {
         ModelData var5 = ModelData.method1491(class172.field2367, this.field2954, 0);
         if(var5 == null) {
            return null;
         } else {
            if(this.field2981 != 128 || this.field2984 != 128 || this.field2983 != 128) {
               var5.method1508(this.field2981, this.field2984, this.field2983);
            }

            int var4;
            if(this.field2950 != null) {
               for(var4 = 0; var4 < this.field2950.length; ++var4) {
                  var5.method1490(this.field2950[var4], this.field2949[var4]);
               }
            }

            if(this.field2988 != null) {
               for(var4 = 0; var4 < this.field2988.length; ++var4) {
                  var5.method1506(this.field2988[var4], this.field2976[var4]);
               }
            }

            var6 = var5.method1512(this.field2965 + 64, this.field2985 + 768, -50, -10, -50);
            var6.field1399 = true;
            itemModelCache.put(var6, (long)this.id);
            return var6;
         }
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(ZI)Z",
      garbageValue = "1970269998"
   )
   public final boolean method3710(boolean var1) {
      int var2 = this.maleModel;
      int var3 = this.field2953;
      if(var1) {
         var2 = this.field2948;
         var3 = this.field2975;
      }

      if(var2 == -1) {
         return true;
      } else {
         boolean var4 = true;
         if(!class172.field2367.method3347(var2, 0)) {
            var4 = false;
         }

         if(var3 != -1 && !class172.field2367.method3347(var3, 0)) {
            var4 = false;
         }

         return var4;
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(II)LItemComposition;",
      garbageValue = "-720420542"
   )
   public ItemComposition method3716(int var1) {
      if(this.field2966 != null && var1 > 1) {
         int var2 = -1;

         for(int var3 = 0; var3 < 10; ++var3) {
            if(var1 >= this.field2978[var3] && this.field2978[var3] != 0) {
               var2 = this.field2966[var3];
            }
         }

         if(var2 != -1) {
            return class18.getItemDefinition(var2);
         }
      }

      return this;
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "656382823"
   )
   static void method3726() {
      Client var0 = Client.field281;
      synchronized(Client.field281) {
         Container var1 = Client.field281.method2156();
         if(null != var1) {
            class166.field2322 = Math.max(var1.getSize().width, class7.field63);
            class49.field953 = Math.max(var1.getSize().height, SecondaryBufferProvider.field3197);
            Insets var2;
            if(MessageNode.field230 == var1) {
               var2 = MessageNode.field230.getInsets();
               class166.field2322 -= var2.left + var2.right;
               class49.field953 -= var2.top + var2.bottom;
            }

            if(class166.field2322 <= 0) {
               class166.field2322 = 1;
            }

            if(class49.field953 <= 0) {
               class49.field953 = 1;
            }

            if(class105.method2061() == 1) {
               class16.field169 = Client.field500;
               class65.field1103 = Client.field520 * 503;
            } else {
               class16.field169 = Math.min(class166.field2322, 7680);
               class65.field1103 = Math.min(class49.field953, 2160);
            }

            GameEngine.field1776 = (class166.field2322 - class16.field169) / 2;
            GameEngine.field1783 = 0;
            class107.canvas.setSize(class16.field169, class65.field1103);
            class34.bufferProvider = class116.method2298(class16.field169, class65.field1103, class107.canvas);
            if(var1 == MessageNode.field230) {
               var2 = MessageNode.field230.getInsets();
               class107.canvas.setLocation(GameEngine.field1776 + var2.left, GameEngine.field1783 + var2.top);
            } else {
               class107.canvas.setLocation(GameEngine.field1776, GameEngine.field1783);
            }

            XClanMember.method264();
            if(Client.widgetRoot != -1) {
               class101.method1990(Client.widgetRoot, class16.field169, class65.field1103, true);
            }

            WidgetNode.method203();
         }
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IB)LModelData;",
      garbageValue = "-19"
   )
   public final ModelData method3737(int var1) {
      int var3;
      if(this.field2966 != null && var1 > 1) {
         int var2 = -1;

         for(var3 = 0; var3 < 10; ++var3) {
            if(var1 >= this.field2978[var3] && this.field2978[var3] != 0) {
               var2 = this.field2966[var3];
            }
         }

         if(var2 != -1) {
            return class18.getItemDefinition(var2).method3737(1);
         }
      }

      ModelData var4 = ModelData.method1491(class172.field2367, this.field2954, 0);
      if(var4 == null) {
         return null;
      } else {
         if(this.field2981 != 128 || this.field2984 != 128 || this.field2983 != 128) {
            var4.method1508(this.field2981, this.field2984, this.field2983);
         }

         if(null != this.field2950) {
            for(var3 = 0; var3 < this.field2950.length; ++var3) {
               var4.method1490(this.field2950[var3], this.field2949[var3]);
            }
         }

         if(this.field2988 != null) {
            for(var3 = 0; var3 < this.field2988.length; ++var3) {
               var4.method1506(this.field2988[var3], this.field2976[var3]);
            }
         }

         return var4;
      }
   }
}
