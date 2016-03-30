import java.applet.Applet;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ef")
public class class138 {
   @ObfuscatedName("w")
   public static Applet field2148 = null;
   @ObfuscatedName("x")
   public static String field2151 = null;
   @ObfuscatedName("t")
   static class167 field2153;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "742936395"
   )
   static void method2937(int var0) {
      if(client.field303 != var0) {
         if(client.field303 == 0) {
            class109.field1916 = null;
            class22.field606 = null;
            class13.field212 = null;
         }

         if(var0 == 20 || var0 == 40 || var0 == 45) {
            client.field327 = 0;
            client.field328 = 0;
            client.field336 = 0;
         }

         if(20 != var0 && var0 != 40 && class31.field743 != null) {
            class31.field743.method3005();
            class31.field743 = null;
         }

         if(client.field303 == 25) {
            client.field524 = 0;
            client.field348 = 0;
            client.field530 = 1;
            client.field563 = 0;
            client.field351 = 1;
         }

         if(5 != var0 && 10 != var0) {
            if(var0 == 20) {
               class18.method194(class87.field1537, class4.field82, class35.field795, true, 11 == client.field303?4:0);
            } else if(11 == var0) {
               class18.method194(class87.field1537, class4.field82, class35.field795, false, 4);
            } else if(class31.field715) {
               class31.field731 = null;
               class31.field717 = null;
               class139.field2162 = null;
               class161.field2668 = null;
               class213.field3152 = null;
               class139.field2156 = null;
               class33.field779 = null;
               class189.field3061 = null;
               class90.field1566 = null;
               class76.field1393 = null;
               class30.field712 = null;
               class134.field2089 = null;
               class129.field2063 = null;
               class95.field1627 = null;
               class96.field1645 = null;
               class122.field2025 = null;
               class106.field1883 = null;
               class229.field3232 = null;
               class4.field87 = null;
               class31.field737 = null;
               class48.field1097 = null;
               class28.field684 = null;
               class52.method1116(2);
               class77.method1685(true);
               class31.field715 = false;
            }
         } else {
            class18.method194(class87.field1537, class4.field82, class35.field795, true, 0);
         }

         client.field303 = var0;
      }
   }
}
