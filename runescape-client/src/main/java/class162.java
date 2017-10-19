import java.awt.Component;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fq")
public class class162 {
   @ObfuscatedName("q")
   static int[][] field2302;
   @ObfuscatedName("o")
   static int[][] field2295;
   @ObfuscatedName("e")
   static int[] field2298;
   @ObfuscatedName("d")
   static int[] field2299;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1157522711
   )
   static int field2296;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 219591655
   )
   static int field2292;
   @ObfuscatedName("kk")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   static Widget field2303;

   static {
      field2302 = new int[128][128];
      field2295 = new int[128][128];
      field2298 = new int[4096];
      field2299 = new int[4096];
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "1289817405"
   )
   static void method3122(Component var0) {
      var0.addMouseListener(MouseInput.mouse);
      var0.addMouseMotionListener(MouseInput.mouse);
      var0.addFocusListener(MouseInput.mouse);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(III)Lbb;",
      garbageValue = "-374382109"
   )
   static MessageNode method3123(int var0, int var1) {
      ChatLineBuffer var2 = (ChatLineBuffer)class96.chatLineMap.get(Integer.valueOf(var0));
      return var2.method1917(var1);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)Ljava/lang/String;",
      garbageValue = "377595057"
   )
   public static String method3121(CharSequence var0) {
      int var1 = var0.length();
      StringBuilder var2 = new StringBuilder(var1);

      for(int var3 = 0; var3 < var1; ++var3) {
         char var4 = var0.charAt(var3);
         if((var4 < 'a' || var4 > 'z') && (var4 < 'A' || var4 > 'Z') && (var4 < '0' || var4 > '9') && var4 != '.' && var4 != '-' && var4 != '*' && var4 != '_') {
            if(var4 == ' ') {
               var2.append('+');
            } else {
               byte var5 = class28.method246(var4);
               var2.append('%');
               int var6 = var5 >> 4 & 15;
               if(var6 >= 10) {
                  var2.append((char)(var6 + 55));
               } else {
                  var2.append((char)(var6 + 48));
               }

               var6 = var5 & 15;
               if(var6 >= 10) {
                  var2.append((char)(var6 + 55));
               } else {
                  var2.append((char)(var6 + 48));
               }
            }
         } else {
            var2.append(var4);
         }
      }

      return var2.toString();
   }
}
