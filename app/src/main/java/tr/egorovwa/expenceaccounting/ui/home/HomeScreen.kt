package tr.egorovwa.expenceaccounting.ui.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import tr.egorovwa.expenceaccounting.AppViewModelProvider
import tr.egorovwa.expenceaccounting.ExpenceTopAppBar
import tr.egorovwa.expenceaccounting.R
import tr.egorovwa.expenceaccounting.ui.day.DATE_TIME_FORMATER
import tr.egorovwa.expenceaccounting.ui.day.Day
import tr.egorovwa.expenceaccounting.ui.navigation.NavigationDestination
import java.text.NumberFormat

object HomeDestination : NavigationDestination {
    override val route: String = "home"
    override val title: Int = R.string.home_screen_title
}

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = viewModel(factory = AppViewModelProvider.factory)
) {
    val homeUiState by viewModel.homeUiState.collectAsState()
    Scaffold(
        topBar = {
            ExpenceTopAppBar(
                title = stringResource(id = HomeDestination.title),
                canNavigateBack = false
            )
        }
    ) {
        HomeBody(
            modifier = modifier.padding(it),
            days = homeUiState.days,
            onDayClicked = { TODO("On day cliced impl") }
        )
    }
}

@Composable
fun HomeBody(
    modifier: Modifier = Modifier,
    days: List<Day>,
    onDayClicked: (Day) -> Unit,

    ) {
    if (days.isEmpty()){
        Text(text = "Expences not found")
    }else{
        DaysList(days = days, onDayClicked = onDayClicked)
    }

}


@Composable
fun DaysList(
    modifier: Modifier = Modifier,
    days: List<Day>,
    onDayClicked: (Day) -> Unit,
) {
    LazyColumn(modifier = modifier, verticalArrangement = Arrangement.spacedBy(8.dp)) {
        items(items = days, key = { it.date }) { day ->
            DayItem(day = day, onDayClicked = { onDayClicked(day) })
            Divider()
        }
    }
}


@Composable
fun DayItem(
    modifier: Modifier = Modifier,
    day: Day,
    onDayClicked: (Day) -> Unit
) {
    Card(
        modifier = modifier
            .clickable { onDayClicked(day) },
        border = BorderStroke(3.dp, color = MaterialTheme.colors.onBackground)
    ) {
        Row(horizontalArrangement = Arrangement.SpaceBetween) {
            Text(text = day.date.format(DATE_TIME_FORMATER), style = MaterialTheme.typography.h6)
            Text(text = NumberFormat.getCurrencyInstance().format(day.getSum()))
        }
    }
}

@Preview
@Composable
fun PreviewHomeScreen() {
    HomeScreen(

    )
}