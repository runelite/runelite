import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.URL;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("di")
public final class class107 {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -348468741
   )
   int field1837;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1698412609
   )
   int field1838;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1401219431
   )
   int field1839;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1536075021
   )
   int field1840;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 971317597
   )
   int field1841;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1098009155
   )
   int field1842;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1541925411
   )
   int field1843;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 971758023
   )
   int field1844;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1993645177
   )
   int field1845;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -579333225
   )
   int field1846;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -367269469
   )
   int field1847;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -269318725
   )
   int field1848;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 612356813
   )
   int field1849;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 150635681
   )
   int field1850;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -231230521
   )
   int field1851;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -95289427
   )
   int field1852;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1440511293
   )
   int field1853;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1180665817
   )
   int field1854;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;B)Z",
      garbageValue = "58"
   )
   public static final boolean method2356(String var0, String var1, String var2, String var3) {
      return null != var0 && null != var2?(!var0.startsWith("#") && !var2.startsWith("#")?var1.equals(var3):var0.equals(var2)):false;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/Throwable;I)V",
      garbageValue = "1969866009"
   )
   public static void method2357(String var0, Throwable var1) {
      try {
         String var2 = "";
         if(var1 != null) {
            Throwable var4 = var1;
            String var5;
            if(var1 instanceof class151) {
               class151 var6 = (class151)var1;
               var5 = var6.field2278 + " | ";
               var4 = var6.field2279;
            } else {
               var5 = "";
            }

            StringWriter var18 = new StringWriter();
            PrintWriter var7 = new PrintWriter(var18);
            var4.printStackTrace(var7);
            var7.close();
            String var8 = var18.toString();
            BufferedReader var9 = new BufferedReader(new StringReader(var8));
            String var10 = var9.readLine();

            while(true) {
               String var11 = var9.readLine();
               if(var11 == null) {
                  var5 = var5 + "| " + var10;
                  var2 = var5;
                  break;
               }

               int var12 = var11.indexOf(40);
               int var13 = var11.indexOf(41, 1 + var12);
               if(var12 >= 0 && var13 >= 0) {
                  String var14 = var11.substring(1 + var12, var13);
                  int var15 = var14.indexOf(".java:");
                  if(var15 >= 0) {
                     var14 = var14.substring(0, var15) + var14.substring(5 + var15);
                     var5 = var5 + var14 + ' ';
                     continue;
                  }

                  var11 = var11.substring(0, var12);
               }

               var11 = var11.trim();
               var11 = var11.substring(var11.lastIndexOf(32) + 1);
               var11 = var11.substring(var11.lastIndexOf(9) + 1);
               var5 = var5 + var11 + ' ';
            }
         }

         if(null != var0) {
            if(null != var1) {
               var2 = var2 + " | ";
            }

            var2 = var2 + var0;
         }

         System.out.println("Error: " + var2);
         var2 = var2.replace(':', '.');
         var2 = var2.replace('@', '_');
         var2 = var2.replace('&', '_');
         var2 = var2.replace('#', '_');
         if(class151.field2280 == null) {
            return;
         }

         URL var3 = new URL(class151.field2280.getCodeBase(), "clienterror.ws?c=" + class192.field3104 + "&u=" + class151.field2277 + "&v1=" + class139.field2141 + "&v2=" + class139.field2138 + "&e=" + var2);
         DataInputStream var17 = new DataInputStream(var3.openStream());
         var17.read();
         var17.close();
      } catch (Exception var16) {
         ;
      }

   }
}
