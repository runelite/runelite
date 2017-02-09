import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bf")
public class class60 {
   @ObfuscatedName("ju")
   static Widget[] field1078;
   @ObfuscatedName("c")
   static ModIcon field1079;
   @ObfuscatedName("o")
   XHashTable field1080 = new XHashTable(256);
   @ObfuscatedName("r")
   XHashTable field1081 = new XHashTable(256);
   @ObfuscatedName("y")
   class182 field1082;
   @ObfuscatedName("l")
   static int[] field1083;
   @ObfuscatedName("qj")
   @ObfuscatedGetter(
      intValue = 56043929
   )
   protected static int field1084;
   @ObfuscatedName("k")
   class182 field1085;

   @ObfuscatedName("sj")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-82"
   )
   protected static final void method1146() {
      class110.field1753 = null;
      ChatLineBuffer.field970 = null;
      class7.field60 = null;
   }

   @ObfuscatedName("k")
   public static String method1147(long var0) {
      if(var0 > 0L && var0 < 6582952005840035281L) {
         if(0L == var0 % 37L) {
            return null;
         } else {
            int var2 = 0;

            for(long var3 = var0; 0L != var3; var3 /= 37L) {
               ++var2;
            }

            StringBuilder var5 = new StringBuilder(var2);

            while(var0 != 0L) {
               long var6 = var0;
               var0 /= 37L;
               var5.append(class205.field3075[(int)(var6 - 37L * var0)]);
            }

            return var5.reverse().toString();
         }
      } else {
         return null;
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I[IB)Lclass55;",
      garbageValue = "66"
   )
   public class55 method1148(int var1, int[] var2) {
      if(this.field1085.method3270() == 1) {
         return this.method1153(0, var1, var2);
      } else if(this.field1085.method3283(var1) == 1) {
         return this.method1153(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I[II)Lclass55;",
      garbageValue = "1195026788"
   )
   public class55 method1149(int var1, int[] var2) {
      if(this.field1082.method3270() == 1) {
         return this.method1157(0, var1, var2);
      } else if(this.field1082.method3283(var1) == 1) {
         return this.method1157(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II[II)Lclass55;",
      garbageValue = "1141599284"
   )
   class55 method1153(int var1, int var2, int[] var3) {
      int var4 = var2 ^ (var1 << 4 & '\uffff' | var1 >>> 12);
      var4 |= var1 << 16;
      long var5 = (long)var4;
      class55 var7 = (class55)this.field1081.method2331(var5);
      if(null != var7) {
         return var7;
      } else if(var3 != null && var3[0] <= 0) {
         return null;
      } else {
         class53 var8 = class53.method986(this.field1085, var1, var2);
         if(null == var8) {
            return null;
         } else {
            var7 = var8.method980();
            this.field1081.method2333(var7, var5);
            if(null != var3) {
               var3[0] -= var7.field1023.length;
            }

            return var7;
         }
      }
   }

   public class60(class182 var1, class182 var2) {
      this.field1085 = var1;
      this.field1082 = var2;
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-65"
   )
   static final void method1156() {
      for(int var0 = 0; var0 < Client.field461; ++var0) {
         --Client.field533[var0];
         if(Client.field533[var0] >= -10) {
            class53 var9 = Client.field400[var0];
            if(null == var9) {
               Object var10000 = null;
               var9 = class53.method986(Friend.field152, Client.field473[var0], 0);
               if(null == var9) {
                  continue;
               }

               Client.field533[var0] += var9.method982();
               Client.field400[var0] = var9;
            }

            if(Client.field533[var0] < 0) {
               int var2;
               if(Client.field524[var0] != 0) {
                  int var10 = 128 * (Client.field524[var0] & 255);
                  int var4 = Client.field524[var0] >> 16 & 255;
                  int var5 = 64 + var4 * 128 - VertexNormal.localPlayer.x;
                  if(var5 < 0) {
                     var5 = -var5;
                  }

                  int var6 = Client.field524[var0] >> 8 & 255;
                  int var7 = 128 * var6 + 64 - VertexNormal.localPlayer.y;
                  if(var7 < 0) {
                     var7 = -var7;
                  }

                  int var8 = var7 + var5 - 128;
                  if(var8 > var10) {
                     Client.field533[var0] = -100;
                     continue;
                  }

                  if(var8 < 0) {
                     var8 = 0;
                  }

                  var2 = Client.field512 * (var10 - var8) / var10;
               } else {
                  var2 = Client.field518;
               }

               if(var2 > 0) {
                  class55 var3 = var9.method980().method1026(class22.field237);
                  class66 var11 = class66.method1304(var3, 100, var2);
                  var11.method1196(Client.field522[var0] - 1);
                  class164.field2290.method918(var11);
               }

               Client.field533[var0] = -100;
            }
         } else {
            --Client.field461;

            for(int var1 = var0; var1 < Client.field461; ++var1) {
               Client.field473[var1] = Client.field473[1 + var1];
               Client.field400[var1] = Client.field400[var1 + 1];
               Client.field522[var1] = Client.field522[var1 + 1];
               Client.field533[var1] = Client.field533[1 + var1];
               Client.field524[var1] = Client.field524[var1 + 1];
            }

            --var0;
         }
      }

      if(Client.field517) {
         boolean var12;
         if(class138.field1910 != 0) {
            var12 = true;
         } else {
            var12 = class138.field1906.method2475();
         }

         if(!var12) {
            if(Client.field515 != 0 && Client.field516 != -1) {
               class159.method2909(ChatMessages.field923, Client.field516, 0, Client.field515, false);
            }

            Client.field517 = false;
         }
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(II[IB)Lclass55;",
      garbageValue = "1"
   )
   class55 method1157(int var1, int var2, int[] var3) {
      int var4 = var2 ^ (var1 << 4 & '\uffff' | var1 >>> 12);
      var4 |= var1 << 16;
      long var5 = (long)var4 ^ 4294967296L;
      class55 var7 = (class55)this.field1081.method2331(var5);
      if(var7 != null) {
         return var7;
      } else if(null != var3 && var3[0] <= 0) {
         return null;
      } else {
         class54 var8 = (class54)this.field1080.method2331(var5);
         if(var8 == null) {
            var8 = class54.method1003(this.field1082, var1, var2);
            if(null == var8) {
               return null;
            }

            this.field1080.method2333(var8, var5);
         }

         var7 = var8.method1002(var3);
         if(null == var7) {
            return null;
         } else {
            var8.unlink();
            this.field1081.method2333(var7, var5);
            return var7;
         }
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Lclass182;III)LSpritePixels;",
      garbageValue = "1366595393"
   )
   public static SpritePixels method1158(class182 var0, int var1, int var2) {
      return !class63.method1175(var0, var1, var2)?null:class161.method3135();
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "87"
   )
   static final void method1159() {
      Client.field397 = 0;
      int var0 = (VertexNormal.localPlayer.x >> 7) + class114.baseX;
      int var1 = CombatInfo1.baseY + (VertexNormal.localPlayer.y >> 7);
      if(var0 >= 3053 && var0 <= 3156 && var1 >= 3056 && var1 <= 3136) {
         Client.field397 = 1;
      }

      if(var0 >= 3072 && var0 <= 3118 && var1 >= 9492 && var1 <= 9535) {
         Client.field397 = 1;
      }

      if(Client.field397 == 1 && var0 >= 3139 && var0 <= 3199 && var1 >= 3008 && var1 <= 3062) {
         Client.field397 = 0;
      }

   }
}
