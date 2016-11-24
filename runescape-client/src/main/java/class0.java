import java.awt.Component;
import java.io.IOException;
import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("n")
final class class0 implements Comparator {
   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   public int compare(Object var1, Object var2) {
      return this.method1((class2)var1, (class2)var2);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lclass2;Lclass2;B)I",
      garbageValue = "-70"
   )
   int method1(class2 var1, class2 var2) {
      return var1.field24 < var2.field24?-1:(var1.field24 == var2.field24?0:1);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lclass68;I)V",
      garbageValue = "-586511553"
   )
   static final void method9(class68 var0) {
      var0.field1133 = false;
      if(var0.field1135 != null) {
         var0.field1135.field1167 = 0;
      }

      for(class68 var1 = var0.vmethod2748(); null != var1; var1 = var0.vmethod2750()) {
         method9(var1);
      }

   }

   @ObfuscatedName("be")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "870162119"
   )
   static final void method10(boolean var0) {
      class13.method185();
      ++Client.field336;
      if(Client.field336 >= 50 || var0) {
         Client.field336 = 0;
         if(!Client.field425 && null != FileOnDisk.field1183) {
            Client.field330.method3234(155);

            try {
               FileOnDisk.field1183.method2107(Client.field330.payload, 0, Client.field330.offset);
               Client.field330.offset = 0;
            } catch (IOException var2) {
               Client.field425 = true;
            }
         }

      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "-994896005"
   )
   public static void method11(Component var0) {
      var0.addMouseListener(class115.mouse);
      var0.addMouseMotionListener(class115.mouse);
      var0.addFocusListener(class115.mouse);
   }

   @ObfuscatedName("n")
   public static final void method12(long var0) {
      if(var0 > 0L) {
         if(var0 % 10L == 0L) {
            long var2 = var0 - 1L;

            try {
               Thread.sleep(var2);
            } catch (InterruptedException var8) {
               ;
            }

            try {
               Thread.sleep(1L);
            } catch (InterruptedException var7) {
               ;
            }
         } else {
            try {
               Thread.sleep(var0);
            } catch (InterruptedException var6) {
               ;
            }
         }

      }
   }
}
