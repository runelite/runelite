import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("er")
public class class150 extends class297 {
   @ObfuscatedName("o")
   final boolean field2143;

   public class150(boolean var1) {
      this.field2143 = var1;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lkv;Lkv;I)I",
      garbageValue = "-1837614571"
   )
   int method3121(ChatPlayer var1, ChatPlayer var2) {
      return Client.world == var1.world && var2.world == Client.world?(this.field2143?var1.method5271().compareCleanName(var2.method5271()):var2.method5271().compareCleanName(var1.method5271())):this.method5282(var1, var2);
   }

   public int compare(Object var1, Object var2) {
      return this.method3121((ChatPlayer)var1, (ChatPlayer)var2);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "122"
   )
   public static void method3111() {
      class326.classInfos = new CombatInfoList();
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "([BIB)I",
      garbageValue = "27"
   )
   public static int method3118(byte[] var0, int var1) {
      return ClanMember.method5252(var0, 0, var1);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IB)Ljs;",
      garbageValue = "75"
   )
   public static VarPlayerType method3119(int var0) {
      VarPlayerType var1 = (VarPlayerType)VarPlayerType.varplayers.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = VarPlayerType.varplayer_ref.getConfigData(16, var0);
         var1 = new VarPlayerType();
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         VarPlayerType.varplayers.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;IZI)I",
      garbageValue = "1433513111"
   )
   @Export("parseInt")
   public static int parseInt(CharSequence var0, int var1, boolean var2) {
      if(var1 >= 2 && var1 <= 36) {
         boolean var3 = false;
         boolean var4 = false;
         int var5 = 0;
         int var6 = var0.length();

         for(int var7 = 0; var7 < var6; ++var7) {
            char var8 = var0.charAt(var7);
            if(var7 == 0) {
               if(var8 == '-') {
                  var3 = true;
                  continue;
               }

               if(var8 == '+') {
                  continue;
               }
            }

            int var10;
            if(var8 >= '0' && var8 <= '9') {
               var10 = var8 - '0';
            } else if(var8 >= 'A' && var8 <= 'Z') {
               var10 = var8 - '7';
            } else {
               if(var8 < 'a' || var8 > 'z') {
                  throw new NumberFormatException();
               }

               var10 = var8 - 'W';
            }

            if(var10 >= var1) {
               throw new NumberFormatException();
            }

            if(var3) {
               var10 = -var10;
            }

            int var9 = var5 * var1 + var10;
            if(var9 / var1 != var5) {
               throw new NumberFormatException();
            }

            var5 = var9;
            var4 = true;
         }

         if(!var4) {
            throw new NumberFormatException();
         } else {
            return var5;
         }
      } else {
         throw new IllegalArgumentException("");
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "1468676923"
   )
   static synchronized void method3110(byte[] var0) {
      if(var0.length == 100 && class195.field2583 < 1000) {
         class195.field2580[++class195.field2583 - 1] = var0;
      } else if(var0.length == 5000 && class195.field2579 < 250) {
         class195.field2581[++class195.field2579 - 1] = var0;
      } else if(var0.length == 30000 && class195.field2578 < 50) {
         class195.field2585[++class195.field2578 - 1] = var0;
      } else {
         if(class319.field3930 != null) {
            for(int var1 = 0; var1 < class195.field2584.length; ++var1) {
               if(var0.length == class195.field2584[var1] && OwnWorldComparator.field866[var1] < class319.field3930[var1].length) {
                  class319.field3930[var1][OwnWorldComparator.field866[var1]++] = var0;
                  return;
               }
            }
         }

      }
   }
}
