import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("x")
public class class25 {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1602547685
   )
   int field370;
   @ObfuscatedName("w")
   Coordinates field371;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIIIIIIB)V",
      garbageValue = "-6"
   )
   public static final void method165(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7 = Math.min(var3, Math.min(var4, var5)) - var6;
      int var8 = Math.max(var3, Math.max(var4, var5)) + var6;
      int var9 = Math.min(var0, Math.min(var1, var2)) - var6;
      int var10 = Math.max(var0, Math.max(var1, var2)) + var6;
      class7.field234.method3543(new class8(var7, var9, var8, var10, -49088));
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(LSignlink;III)Lclass109;",
      garbageValue = "1241684721"
   )
   public static final class109 method166(Signlink var0, int var1, int var2) {
      if(FileSystem.field3211 == 0) {
         throw new IllegalStateException();
      } else if(var1 >= 0 && var1 < 2) {
         if(var2 < 256) {
            var2 = 256;
         }

         try {
            class109 var3 = class109.field1660.vmethod1927();
            var3.field1649 = new int[256 * (class109.field1664?2:1)];
            var3.field1650 = var2;
            var3.vmethod2029();
            var3.field1653 = (var2 & -1024) + 1024;
            if(var3.field1653 > 16384) {
               var3.field1653 = 16384;
            }

            var3.vmethod2057(var3.field1653);
            if(class109.field1647 > 0 && class157.field2270 == null) {
               class157.field2270 = new class111();
               class170.field2356 = Executors.newScheduledThreadPool(1);
               class170.field2356.scheduleAtFixedRate(class157.field2270, 0L, 10L, TimeUnit.MILLISECONDS);
            }

            if(class157.field2270 != null) {
               if(class157.field2270.field1678[var1] != null) {
                  throw new IllegalArgumentException();
               }

               class157.field2270.field1678[var1] = var3;
            }

            return var3;
         } catch (Throwable var4) {
            return new class109();
         }
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("jr")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)Z",
      garbageValue = "-1952921574"
   )
   static boolean method167(String var0, boolean var1) {
      if(var0 == null) {
         return false;
      } else {
         String var2 = Player.method1179(var0, Client.field928);

         for(int var3 = 0; var3 < Client.friendCount; ++var3) {
            if(var2.equalsIgnoreCase(Player.method1179(Client.friends[var3].name, Client.field928)) && (!var1 || Client.friends[var3].world != 0)) {
               return true;
            }
         }

         if(var2.equalsIgnoreCase(Player.method1179(XItemContainer.localPlayer.name, Client.field928))) {
            return true;
         } else {
            return false;
         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;IIB)[LModIcon;",
      garbageValue = "10"
   )
   static ModIcon[] method168(IndexDataBase var0, int var1, int var2) {
      return !class223.method4073(var0, var1, var2)?null:class155.method2943();
   }

   class25(int var1, Coordinates var2) {
      this.field370 = var1;
      this.field371 = var2;
   }
}
