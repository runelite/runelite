import java.util.zip.Inflater;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eb")
public class class146 {
   @ObfuscatedName("x")
   Inflater field2018;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "744769867"
   )
   static void method2811() {
      FileOnDisk var0 = null;

      try {
         var0 = CombatInfo2.method3608("", Client.field312.field2687, true);
         Buffer var1 = ObjectComposition.field2944.method706();
         var0.method1495(var1.payload, 0, var1.offset);
      } catch (Exception var3) {
         ;
      }

      try {
         if(null != var0) {
            var0.method1488();
         }
      } catch (Exception var2) {
         ;
      }

   }

   public class146() {
      this(-1, 1000000, 1000000);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(LBuffer;[BB)V",
      garbageValue = "-55"
   )
   public void method2812(Buffer var1, byte[] var2) {
      if(var1.payload[var1.offset] == 31 && var1.payload[var1.offset + 1] == -117) {
         if(this.field2018 == null) {
            this.field2018 = new Inflater(true);
         }

         try {
            this.field2018.setInput(var1.payload, 10 + var1.offset, var1.payload.length - (8 + 10 + var1.offset));
            this.field2018.inflate(var2);
         } catch (Exception var4) {
            this.field2018.reset();
            throw new RuntimeException("");
         }

         this.field2018.reset();
      } else {
         throw new RuntimeException("");
      }
   }

   @ObfuscatedName("dp")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "55"
   )
   static void method2815() {
      for(WidgetNode var0 = (WidgetNode)Client.componentTable.method2440(); null != var0; var0 = (WidgetNode)Client.componentTable.method2441()) {
         int var1 = var0.id;
         if(Projectile.method874(var1)) {
            boolean var2 = true;
            Widget[] var3 = class231.widgets[var1];

            int var4;
            for(var4 = 0; var4 < var3.length; ++var4) {
               if(var3[var4] != null) {
                  var2 = var3[var4].hasScript;
                  break;
               }
            }

            if(!var2) {
               var4 = (int)var0.hash;
               Widget var5 = ChatLineBuffer.method993(var4);
               if(null != var5) {
                  ChatLineBuffer.method996(var5);
               }
            }
         }
      }

   }

   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1000000"
   )
   class146(int var1, int var2, int var3) {
   }
}
