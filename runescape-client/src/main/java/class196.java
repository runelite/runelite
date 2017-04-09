import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gc")
public class class196 extends CacheableNode {
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -479158701
   )
   public int field2873 = 0;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1035313605
   )
   int field2874 = -1;
   @ObfuscatedName("h")
   static NodeCache field2875 = new NodeCache(64);
   @ObfuscatedName("r")
   @Export("spriteCache")
   static NodeCache spriteCache = new NodeCache(64);
   @ObfuscatedName("o")
   static NodeCache field2877 = new NodeCache(20);
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1599597345
   )
   int field2879 = -1;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 139153405
   )
   public int field2880 = -1;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -588761303
   )
   public int field2881 = 70;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 607611985
   )
   public int field2882 = 16777215;
   @ObfuscatedName("i")
   public static IndexDataBase field2883;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 2082642831
   )
   int field2884 = -1;
   @ObfuscatedName("f")
   public static IndexDataBase field2885;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1046639183
   )
   public int field2886 = 0;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -334963637
   )
   int field2887 = -1;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1848752883
   )
   int field2888 = -1;
   @ObfuscatedName("b")
   String field2889 = "";
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 798314189
   )
   public int field2890 = -1;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -928480163
   )
   public int field2891 = 0;
   @ObfuscatedName("c")
   public int[] field2892;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -782914593
   )
   int field2893 = -1;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = -1897615971
   )
   int field2894 = -1;

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)Lclass196;",
      garbageValue = "-1385847813"
   )
   public final class196 method3605() {
      int var1 = -1;
      if(this.field2893 != -1) {
         var1 = class25.method560(this.field2893);
      } else if(this.field2894 != -1) {
         var1 = class165.widgetSettings[this.field2894];
      }

      int var2;
      if(var1 >= 0 && var1 < this.field2892.length - 1) {
         var2 = this.field2892[var1];
      } else {
         var2 = this.field2892[this.field2892.length - 1];
      }

      return var2 != -1?class114.method2258(var2):null;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IB)Ljava/lang/String;",
      garbageValue = "63"
   )
   public String method3608(int var1) {
      String var2 = this.field2889;

      while(true) {
         int var3 = var2.indexOf("%1");
         if(var3 < 0) {
            return var2;
         }

         String var4 = var2.substring(0, var3);
         String var5 = Integer.toString(var1);
         var2 = var4 + var5 + var2.substring(var3 + 2);
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(B)LSpritePixels;",
      garbageValue = "44"
   )
   public SpritePixels method3609() {
      if(this.field2887 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)spriteCache.get((long)this.field2887);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class26.method564(field2883, this.field2887, 0);
            if(var1 != null) {
               spriteCache.put(var1, (long)this.field2887);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(B)LSpritePixels;",
      garbageValue = "57"
   )
   public SpritePixels method3610() {
      if(this.field2888 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)spriteCache.get((long)this.field2888);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class26.method564(field2883, this.field2888, 0);
            if(var1 != null) {
               spriteCache.put(var1, (long)this.field2888);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)LSpritePixels;",
      garbageValue = "861125488"
   )
   public SpritePixels method3611() {
      if(this.field2874 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)spriteCache.get((long)this.field2874);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class26.method564(field2883, this.field2874, 0);
            if(var1 != null) {
               spriteCache.put(var1, (long)this.field2874);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)LSpritePixels;",
      garbageValue = "-1405882942"
   )
   public SpritePixels method3612() {
      if(this.field2884 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)spriteCache.get((long)this.field2884);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class26.method564(field2883, this.field2884, 0);
            if(var1 != null) {
               spriteCache.put(var1, (long)this.field2884);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)LFont;",
      garbageValue = "-1848587401"
   )
   public Font method3613() {
      if(this.field2879 == -1) {
         return null;
      } else {
         Font var1 = (Font)field2877.get((long)this.field2879);
         if(var1 != null) {
            return var1;
         } else {
            var1 = XItemContainer.method157(field2883, class0.field5, this.field2879, 0);
            if(var1 != null) {
               field2877.put(var1, (long)this.field2879);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "1521507161"
   )
   void method3618(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3634(var1, var2);
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II)LItemComposition;",
      garbageValue = "-479833695"
   )
   @Export("getItemDefinition")
   public static ItemComposition getItemDefinition(int var0) {
      ItemComposition var1 = (ItemComposition)ItemComposition.field2952.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = Frames.field1592.getConfigData(10, var0);
         var1 = new ItemComposition();
         var1.id = var0;
         if(var2 != null) {
            var1.loadBuffer(new Buffer(var2));
         }

         var1.method3679();
         if(var1.notedTemplate != -1) {
            var1.method3692(getItemDefinition(var1.notedTemplate), getItemDefinition(var1.note));
         }

         if(var1.field2951 != -1) {
            var1.method3691(getItemDefinition(var1.field2951), getItemDefinition(var1.field2963));
         }

         if(var1.field3001 != -1) {
            var1.method3693(getItemDefinition(var1.field3001), getItemDefinition(var1.field2958));
         }

         if(!class109.isMembersWorld && var1.isMembers) {
            var1.name = "Members object";
            var1.field2997 = false;
            var1.groundActions = null;
            var1.inventoryActions = null;
            var1.team = -1;
            var1.field2998 = 0;
         }

         ItemComposition.field2952.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-1860004764"
   )
   void method3634(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field2879 = var1.method2882();
      } else if(var2 == 2) {
         this.field2882 = var1.read24BitInt();
      } else if(var2 == 3) {
         this.field2887 = var1.method2882();
      } else if(var2 == 4) {
         this.field2874 = var1.method2882();
      } else if(var2 == 5) {
         this.field2888 = var1.method2882();
      } else if(var2 == 6) {
         this.field2884 = var1.method2882();
      } else if(var2 == 7) {
         this.field2886 = var1.readShort();
      } else if(var2 == 8) {
         this.field2889 = var1.method2876();
      } else if(var2 == 9) {
         this.field2881 = var1.readUnsignedShort();
      } else if(var2 == 10) {
         this.field2873 = var1.readShort();
      } else if(var2 == 11) {
         this.field2880 = 0;
      } else if(var2 == 12) {
         this.field2890 = var1.readUnsignedByte();
      } else if(var2 == 13) {
         this.field2891 = var1.readShort();
      } else if(var2 == 14) {
         this.field2880 = var1.readUnsignedShort();
      } else if(var2 == 17 || var2 == 18) {
         this.field2893 = var1.readUnsignedShort();
         if(this.field2893 == '\uffff') {
            this.field2893 = -1;
         }

         this.field2894 = var1.readUnsignedShort();
         if(this.field2894 == '\uffff') {
            this.field2894 = -1;
         }

         int var3 = -1;
         if(var2 == 18) {
            var3 = var1.readUnsignedShort();
            if(var3 == '\uffff') {
               var3 = -1;
            }
         }

         int var4 = var1.readUnsignedByte();
         this.field2892 = new int[var4 + 2];

         for(int var5 = 0; var5 <= var4; ++var5) {
            this.field2892[var5] = var1.readUnsignedShort();
            if(this.field2892[var5] == '\uffff') {
               this.field2892[var5] = -1;
            }
         }

         this.field2892[var4 + 1] = var3;
      }

   }
}
