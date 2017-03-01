import java.awt.Image;
import java.awt.event.ActionEvent;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bb")
public class class63 implements Runnable {
   @ObfuscatedName("n")
   volatile class57[] field1101 = new class57[2];
   @ObfuscatedName("g")
   volatile boolean field1102 = false;
   @ObfuscatedName("v")
   volatile boolean field1103 = false;
   @ObfuscatedName("qq")
   @ObfuscatedGetter(
      intValue = -194361735
   )
   protected static int field1106;
   @ObfuscatedName("x")
   class103 field1107;
   @ObfuscatedName("rj")
   static Image field1108;

   public void run() {
      this.field1103 = true;

      try {
         while(!this.field1102) {
            class57 var2;
            for(int var1 = 0; var1 < 2; ++var1) {
               var2 = this.field1101[var1];
               if(var2 != null) {
                  var2.method1123();
               }
            }

            class47.method970(10L);
            class103 var5 = this.field1107;
            var2 = null;
            if(var5.field1679 != null) {
               for(int var3 = 0; var3 < 50 && var5.field1679.peekEvent() != null; ++var3) {
                  class47.method970(1L);
               }

               if(var2 != null) {
                  var5.field1679.postEvent(new ActionEvent(var2, 1001, "dummy"));
               }
            }
         }
      } catch (Exception var8) {
         class97.method2025((String)null, var8);
      } finally {
         this.field1103 = false;
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Object;ZS)[B",
      garbageValue = "6994"
   )
   public static byte[] method1236(Object var0, boolean var1) {
      if(null == var0) {
         return null;
      } else if(var0 instanceof byte[]) {
         byte[] var6 = (byte[])((byte[])var0);
         if(var1) {
            int var4 = var6.length;
            byte[] var5 = new byte[var4];
            System.arraycopy(var6, 0, var5, 0, var4);
            return var5;
         } else {
            return var6;
         }
      } else if(var0 instanceof class156) {
         class156 var2 = (class156)var0;
         return var2.vmethod3115();
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("cp")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "178463895"
   )
   static void method1239() {
      for(int var0 = 0; var0 < Client.menuOptionCount; ++var0) {
         int var2 = Client.menuTypes[var0];
         boolean var1 = var2 == 57 || var2 == 58 || var2 == 1007 || var2 == 25 || var2 == 30;
         if(var1) {
            if(var0 < Client.menuOptionCount - 1) {
               for(int var3 = var0; var3 < Client.menuOptionCount - 1; ++var3) {
                  Client.menuOptions[var3] = Client.menuOptions[1 + var3];
                  Client.menuTargets[var3] = Client.menuTargets[var3 + 1];
                  Client.menuTypes[var3] = Client.menuTypes[var3 + 1];
                  Client.menuIdentifiers[var3] = Client.menuIdentifiers[1 + var3];
                  Client.menuActionParams0[var3] = Client.menuActionParams0[1 + var3];
                  Client.menuActionParams1[var3] = Client.menuActionParams1[1 + var3];
               }
            }

            --Client.menuOptionCount;
         }
      }

   }
}
