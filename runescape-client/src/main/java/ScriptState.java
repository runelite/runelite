import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bz")
@Implements("ScriptState")
public class ScriptState {
   @ObfuscatedName("qb")
   @ObfuscatedSignature(
      signature = "Lli;"
   )
   @Export("renderOverview")
   static RenderOverview renderOverview;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "[Lkh;"
   )
   @Export("runeSprites")
   static IndexedSprite[] runeSprites;
   @ObfuscatedName("ap")
   static int[] field708;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lcd;"
   )
   @Export("invokedFromScript")
   Script invokedFromScript;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1810912073
   )
   @Export("invokedFromPc")
   int invokedFromPc;
   @ObfuscatedName("w")
   @Export("savedLocalInts")
   int[] savedLocalInts;
   @ObfuscatedName("s")
   @Export("savedLocalStrings")
   String[] savedLocalStrings;

   ScriptState() {
      this.invokedFromPc = -1;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-5733659"
   )
   static final void method1050(String var0) {
      class63.method1054("Please remove " + var0 + " from your friend list first");
   }

   @ObfuscatedName("ks")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1601858955"
   )
   static final void method1051() {
      Iterator var0 = class94.messages.iterator();

      while(var0.hasNext()) {
         MessageNode var1 = (MessageNode)var0.next();
         var1.method1093();
      }

      if(class234.clanMemberManager != null) {
         class234.clanMemberManager.method5167();
      }

   }
}
